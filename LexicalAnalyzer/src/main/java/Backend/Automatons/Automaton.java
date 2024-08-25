package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public abstract class Automaton {
  protected char [] capitalLetters = {'A','B','C','D','E','F','G','H','I','J','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  protected char [] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  protected char [] numbers = {'1','2','3','4','5','6','7','8','9'};
  protected char [] chars;
  protected Token token;
  protected String lexeme;
  protected boolean isToken = false;
  protected int current = 0;

  public abstract boolean isToken(String string);

    public Token getToken(int column, int row) {
        token.setRow(row);
        token.setColumn(column);
        return token;
    }

    protected boolean isLetterOrCapitalLetter(char symbol) {
        boolean flag = false;
        char[] allLetters = new char[letters.length + capitalLetters.length];
        System.arraycopy(letters, 0, allLetters, 0, letters.length);
        System.arraycopy(capitalLetters, 0, allLetters, letters.length, capitalLetters.length);
        for (char allLetter : allLetters) {
            if (symbol == allLetter) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected boolean isNumber(char symbol) {
        boolean flag = false;
        for (char number : numbers) {
            if (symbol == number) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected boolean isTheLast(){
        return current == (chars.length - 1);
    }

    protected boolean isAReservedWord(char [] word){
        boolean flag = false;
        current ++;
        for (char c : word){
            if ( isTheLast() && c == chars[current]) {
                isToken = true;
                flag = true;
                break;
            } else  if (c == chars[current]) {
                current++;
            } else {
                break;
            }
        }
        return flag;
    }
}
