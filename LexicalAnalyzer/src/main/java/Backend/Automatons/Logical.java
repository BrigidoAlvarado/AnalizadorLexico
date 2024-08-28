package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

import java.lang.reflect.Array;

public class Logical extends Automaton {

    private static final char [] AND = {'A','n','d'};
    private static final char [] OR = {'O','r'};
    private static final char [] NOT = {'N','o','t'};

    @Override
    public boolean isToken(String string) {

        lexeme = string;
        chars = lexeme.toCharArray();
        try {
            switch (chars[0]) {
                case 'A':
                    isAnd();
                    break;
                case 'O':
                    isOr();
                    break;
                case 'N':
                    isNot();
                    break;
                default:
                    isToken = false;

            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
            System.out.println("retornando false desde logical");
            return false;
        }
    }

    private void isAnd(){
        current = 0;
        for (char c : AND){
            if ( isTheLast() && c == chars[current]) {
                isToken = true;
                token = new Token(lexeme, TokensTypes.y.color, TokensTypes.y.name());
                break;
            } else  if (c == chars[current]) {
                current++;
            } else {
                isToken = false;
                break;
            }
        }
    }

    private void isOr (){
        current = 0;
        for (char c : OR){
            if ( isTheLast() && c == chars[current]) {
                isToken = true;
                token = new Token(lexeme, TokensTypes.o.color, TokensTypes.o.name());
                break;
            } else  if (c == chars[current]) {
                current++;
            } else {
                isToken = false;
                break;
            }
        }
    }

    private void isNot(){
        current = 0;
        for (char c : NOT){
            if ( isTheLast() && c == chars[current]) {
                isToken = true;
                token = new Token(lexeme, TokensTypes.negacion.color, TokensTypes.negacion.name());
                break;
            } else  if (c == chars[current]) {
                current++;
            } else {
                isToken = false;
                break;
            }
        }
    }

}
