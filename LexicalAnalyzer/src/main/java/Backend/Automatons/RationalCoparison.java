package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class RationalCoparison   extends Automaton{

    private Token token;

    @Override
    public boolean isToken(String string) {

        lexeme = string;
        chars = string.toCharArray();
        switch (chars[current]) {
            case '=':
                current ++;
                if (chars[current] == '-' ^ isTheLast()) {
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
                    token = new Token(lexeme, TokensTypes.MenorQue.color, TokensTypes.MenorQue.name());
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
                            token = new Token(lexeme, TokensTypes.MenorOIgualQue.color, TokensTypes.MenorOIgualQue.name());
                        }
                    }
                }
                break;
            case '>':
                if (isTheLast()){
                    //Es un token 'Mayor que'
                    isToken = true;
                    token = new Token(lexeme, TokensTypes.MayorQue.color, TokensTypes.MayorQue.name());
                }  else{
                    current++;
                    if (isTheLast() && chars[current] == '='){
                            //Es un token 'Mayor o igual que'
                            isToken = true;
                            token = new Token(lexeme, TokensTypes.MayorOIgualQue.color, TokensTypes.MayorOIgualQue.name());
                        }
                    }
                break;
        }
        return isToken;
    }

    @Override
    public Token getToken(int column, int row) {
        token.setRow(row);
        token.setColumn(column);
        return token;
    }
}
