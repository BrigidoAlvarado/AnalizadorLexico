package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class Identifier  extends Automaton {

    @Override
    public boolean isToken(String string) {
        lexeme = string;
        chars = lexeme.toCharArray();
        if (isLetterOrCapitalLetter(chars[current])){
            caseLetter();
        }
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

    @Override
    public Token getToken(int row, int column) {

        return new Token(lexeme, TokensTypes.Identificador.color, TokensTypes.Identificador.name(),row,column);
    }


}
