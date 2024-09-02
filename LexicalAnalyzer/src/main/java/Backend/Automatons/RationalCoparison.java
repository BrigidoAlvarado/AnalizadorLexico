package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class RationalCoparison extends Automaton{

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();
        try {
            switch (chars[current]) {
                case '=':
                    current ++;
                    if (isTheLast() && (chars[current] == '=')) {
                        //Es un token 'igual'
                        isToken = true;
                        token.authorizeToken(TokensTypes.Igual.color, TokensTypes.Igual.name(), isToken);
                    } else{
                        isToken = false;
                    }
                    break;
                case '<':

                    if (isTheLast()){
                        //Es un token 'Menor que'
                        isToken = true;
                        token.authorizeToken(TokensTypes.Menor_Que.color, TokensTypes.Menor_Que.name(), isToken);
                    } else{
                        current++;
                        if (isTheLast()) {
                            if (chars[current] == '>') {
                                //Es un token 'Diferente'
                                isToken = true;
                                token.authorizeToken(TokensTypes.Diferente.color, TokensTypes.Diferente.name(),isToken);
                            } else if (chars[current] == '=') {
                                //Es un token 'Menor o igual que'
                                isToken = true;
                                token.authorizeToken(TokensTypes.Menor_o_Igual_Que.color, TokensTypes.Menor_o_Igual_Que.name(), isToken);
                            }
                        }
                    }
                    break;
                case '>':
                    if (isTheLast()){
                        //Es un token 'Mayor que'
                        isToken = true;
                        token.authorizeToken(TokensTypes.Mayor_Que.color, TokensTypes.Mayor_Que.name(), isToken);
                    }  else{
                        current++;
                        if (isTheLast() && chars[current] == '='){
                            //Es un token 'Mayor o igual que'
                            isToken = true;
                            token.authorizeToken(TokensTypes.Mayor_o_Igual_Que.color, TokensTypes.Mayor_o_Igual_Que.name(), isToken);
                        }
                    }
                    break;
            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
            System.out.println("retornando false desde rational coparison");
            return false;
        }
    }
}
