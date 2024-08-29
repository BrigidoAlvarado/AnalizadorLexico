package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

import java.lang.reflect.Array;

public class ArithmeticOperator extends Automaton {

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();
        char c = chars[0];
        try {
            switch (c){

                case '+':
                    if (isTheLast()){
                        isToken = true;
                        token.authorizeToken( TokensTypes.Suma.color, TokensTypes.Suma.name(), isToken);
                    }
                    break;
                case '-':
                    if (isTheLast()){
                        isToken = true;
                        token.authorizeToken(TokensTypes.Resta.color, TokensTypes.Resta.name(), isToken);
                    }
                    break;
                case '^':
                    if (isTheLast()){
                        isToken = true;
                        token.authorizeToken(TokensTypes.Exponente.color, TokensTypes.Exponente.name(), isToken);
                    }
                    break;
                case '/':
                    if (isTheLast()){
                        isToken = true;
                        token.authorizeToken(TokensTypes.Division.color, TokensTypes.Division.name(), isToken);
                    }
                    break;
                case '*':
                    if (isTheLast()){
                        isToken = true;
                        token.authorizeToken(TokensTypes.Multiplicacion.color, TokensTypes.Multiplicacion.name(), isToken);
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
                                token.authorizeToken(TokensTypes.Modulo.color, TokensTypes.Modulo.name(),isToken);
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
            //e.printStackTrace();
            System.out.println("retornando false desde operator");
            return false;
        }
    }

}
