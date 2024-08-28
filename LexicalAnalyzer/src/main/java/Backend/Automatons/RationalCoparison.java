package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

import java.lang.reflect.Array;

public class RationalCoparison   extends Automaton{

    @Override
    public boolean isToken(String string) {

        lexeme = string;
        chars = string.toCharArray();
        try {
            switch (chars[current]) {
                case '=':
                    current ++;
                    if (isTheLast() && (chars[current] == '=')) {
                        //Es un token 'igual'
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Igual.color, TokensTypes.Igual.name());
                    } else{
                        isToken = false;
                    }
                    break;
                case '<':

                    if (isTheLast()){
                        //Es un token 'Menor que'
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Menor_Que.color, TokensTypes.Menor_Que.name());
                    } else{
                        current++;
                        if (isTheLast()) {
                            if (chars[current] == '>') {
                                //Es un token 'Diferente'
                                isToken = true;
                                token = new Token(lexeme, TokensTypes.Diferente.color, TokensTypes.Diferente.name());
                            } else if (chars[current] == '=') {
                                //Es un token 'Menor o igual que'
                                isToken = true;
                                token = new Token(lexeme, TokensTypes.Menor_o_Igual_Que.color, TokensTypes.Menor_o_Igual_Que.name());
                            }
                        }
                    }
                    break;
                case '>':
                    if (isTheLast()){
                        //Es un token 'Mayor que'
                        isToken = true;
                        token = new Token(lexeme, TokensTypes.Mayor_Que.color, TokensTypes.Mayor_Que.name());
                    }  else{
                        current++;
                        if (isTheLast() && chars[current] == '='){
                            //Es un token 'Mayor o igual que'
                            isToken = true;
                            token = new Token(lexeme, TokensTypes.Mayor_o_Igual_Que.color, TokensTypes.Mayor_o_Igual_Que.name());
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
