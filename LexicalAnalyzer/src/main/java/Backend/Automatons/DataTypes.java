package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class DataTypes extends Automaton{

    private static final char [] TRUE = {'u','e'};
    private static final char [] FALSE = {'l','s','e'};

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars =lexeme.toCharArray();

        try {
            if (isNumber(chars[current])){
                isToken = true;
                token.authorizeToken(TokensTypes.Entero.color, TokensTypes.Entero.name(),isToken);
                numberWithoutDot();
            } else if (chars[current] == '"'){
                startWithQuotationMarks();
            } else if (chars[current] == '\''){
                if (isTheLast()){
                    isToken = true;
                    token.authorizeToken(TokensTypes.Comentario.color, TokensTypes.Comentario.name(), isToken);
                } else{
                    starWithQuote();
                }
            } else if (chars[current] == 'T' || chars[current] == 'F'){
                booleanType();
            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    private void numberWithoutDot(){
        current++;
        if (current <= (chars.length - 1)){
            if (isNumber(chars[current])){
                isToken = true;
                numberWithoutDot();
            } else if (chars[current] == '.'){
                isToken = false;
                numberWithDot();
            } else {
                isToken = false;
            }
        }
    }

    private void numberWithDot(){
        current++;
        if (current <= (chars.length - 1)){
            if (isNumber(chars[current])){
                isToken = true;
                token.authorizeToken(TokensTypes.Decimal.color, TokensTypes.Decimal.name(), isToken);
                numberWithDot();
            } else {
                isToken = false;
            }
        }
    }

    private void startWithQuotationMarks(){
        current++;
        if (current <= (chars.length - 1)){
            if (isLetterOrCapitalLetter(chars[current]) || isNumber(chars[current])){
                StringContent();
            }
        }
    }

    private void StringContent(){
        current++;
        if (current <= (chars.length - 1)){
            if (isLetterOrCapitalLetter(chars[current]) || isNumber(chars[current])){
                StringContent();
            } else if (chars[current] == '"' &&  isTheLast()){
                // si le sigue una comilla y esta es el ultimo caracter entonces es una cadena
                isToken = true;
                token.authorizeToken(TokensTypes.Cadena.color, TokensTypes.Cadena.name(), isToken);
            }
        }
    }

    private void charContent(){
        current++;
        if (current <= (chars.length - 1)){
            if (chars[current] == '\'' &&  isTheLast()){
                // si le sigue una comilla simple y esta es el ultimo caracter entonces es un caracter
                isToken = true;
                token.authorizeToken(TokensTypes.Caracter.color, TokensTypes.Caracter.name(), isToken);
            } else {
                isToken = true;
                token.authorizeToken(TokensTypes.Comentario.color, TokensTypes.Comentario.name(), isToken);
            }
        } else {
            isToken = true;
            token.authorizeToken(TokensTypes.Comentario.color, TokensTypes.Comentario.name(), isToken);
        }
    }

    private void starWithQuote(){
        current++;
        if (current <= chars.length){
            if (isLetterOrCapitalLetter(chars[current]) || isNumber(chars[current])){
                charContent();
            } else {
                isToken = true;
                token.authorizeToken(TokensTypes.Comentario.color, TokensTypes.Comentario.name(), isToken);
            }
        }
    }

    private void booleanType(){
        current++;
        switch (chars[current]){
            case 'r':
                if (isAReservedFinalWord(TRUE)){
                    isToken = true;
                    token.authorizeToken(TokensTypes.Booleano.color, TokensTypes.Booleano.name(), isToken);
                }
                break;
            case 'a':
                if (isAReservedFinalWord(FALSE)){
                    isToken = true;
                    token.authorizeToken(TokensTypes.Booleano.color, TokensTypes.Booleano.name(),isToken);
                }
                break;
        }
    }
}
