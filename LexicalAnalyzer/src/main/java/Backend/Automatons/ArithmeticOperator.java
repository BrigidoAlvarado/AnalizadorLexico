package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

import java.lang.reflect.Array;

public class ArithmeticOperator extends Automaton {

    @Override
    public boolean isToken(String string) {
        lexeme = string;
        chars = lexeme.toCharArray();
        char c = chars[0];
        try {
            switch (c){

                case '+':
                    if (isTheLast()){
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Suma.color, TokensTypes.Suma.name());
                    }
                    break;
                case '-':
                    if (isTheLast()){
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Resta.color, TokensTypes.Resta.name());
                    }
                    break;
                case '^':
                    if (isTheLast()){
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Exponente.color, TokensTypes.Exponente.name());
                    }
                    break;
                case '/':
                    if (isTheLast()){
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Division.color, TokensTypes.Division.name());
                    }
                    break;
                case '*':
                    if (isTheLast()){
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Multiplicacion.color, TokensTypes.Multiplicacion.name());
                    }
                    break;
                case 'M':
                    current++;
                    char c1 = chars[current];
                    if (c1 == 'o') {
                        current++;
                        char c2 = chars[current];
                        if (c2 == 'd') {
                            if (isTheLast()) {
                                isToken = true;
                                token = new Token(lexeme, TokensTypes.Modulo.color, TokensTypes.Modulo.name());
                            }
                        } else {
                            isToken = false;
                        }
                    } else {
                        isToken = false;
                    }
                    break;

                default:
                    isToken = false;
            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }

}
