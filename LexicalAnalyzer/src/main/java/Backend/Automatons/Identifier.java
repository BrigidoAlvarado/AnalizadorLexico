package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class Identifier  extends Automaton {

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();
        if (isLetterOrCapitalLetter(chars[current])){
            isToken = true;
            caseLetter();
        }
        token.authorizeToken(TokensTypes.Identificador.color, TokensTypes.Identificador.name(), isToken);
        return isToken;
    }

    private void caseLetter(){
        current++;
        if (chars.length > current){
            isToken = true;
            if (isLetterOrCapitalLetter(chars[current])){
                caseLetter();
            }
            else if (isNumber(chars[current])){
                caseNumber();
            } else if (chars[current] == '_'){
                caseUnderscore();
            } else {
                isToken = false;
            }
        }

    }

    private void caseNumber(){
        current++;
        if (chars.length > current){
            isToken = true;
            if (isLetterOrCapitalLetter(chars[current])){
                caseLetter();
            } else if (chars[current] == '_'){
                caseUnderscore();
            } else if (isNumber(chars[current])){
                caseNumber();
            } else {
                isToken = false;
            }
        }

    }

    private void caseUnderscore(){
        current++;
        if (chars.length > current){
            isToken = true;
            if (isLetterOrCapitalLetter(chars[current])){
                caseLetter();
            } else if (isNumber(chars[current])){
                caseNumber();
            } else if (chars[current] == '_'){
                caseUnderscore();
            } else {
                isToken = false;
            }
        }
    }
}
