package Backend.Automatons;

import Backend.Token;

public abstract class Automaton {
  protected static char [] capitalLetters = {'A','B','C','D','E','F','G','H','I','J','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  protected static char [] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z','@','#','$','%','?','!'};
  protected static char [] numbers = {'0','1','2','3','4','5','6','7','8','9'};
  protected char [] chars;
  protected Token token;
  protected String lexeme;
  protected boolean isToken = false;
  protected int current = 0;

  public abstract boolean  validateToken(Token token);

    public static boolean isLetterOrCapitalLetter(char symbol) {
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

    public static boolean isNumber(char symbol) {
        boolean flag = false;
        for (char number : numbers) {
            if (symbol == number) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isACapitalLetter(char symbol){
        boolean flag = false;
        for (char letter : capitalLetters) {
            if (symbol == letter) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected boolean isTheLast(){
        return current == (chars.length - 1);
    }

    protected boolean isAReservedFinalWord(char [] word){
        boolean flag = false;
        int counter = 0;
        current ++;
        if (chars.length >= word.length) {
            for (char c : word){
                counter ++;
                if ( isTheLast() && c == chars[current] && counter == word.length) {
                    flag = true;
                    break;
                } else  if (c == chars[current]) {
                    current ++;
                } else {
                    break;
                }
            }
        }
        return flag;
    }

    protected boolean isAReservedWord(char [] word){
        boolean flag = false;
        current ++;
        int counter = 0;
        if (chars.length > word.length) {
            for (char c : word){
                if (c == chars[current]){
                    if (counter < (word.length - 1)) {
                        current++;
                    } else {
                        flag = true;
                        break;
                    }
                } else {
                    break;
                }
                counter++;
            }
        }
       return flag;
    }
}
