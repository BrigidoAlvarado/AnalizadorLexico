package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class SignsAndSymbols extends Automaton {
    @Override
    public boolean isToken(String string) {
        lexeme = string;
        chars = lexeme.toCharArray();
        switch (chars[current]) {
            case '(',')':
                isToken = isTheLast();
                token = new Token(lexeme, TokensTypes.Parentesis.color, TokensTypes.Parentesis.name());
                break;
            case '{','}':
                isToken = isTheLast();
                token = new Token(lexeme, TokensTypes.Llaves.color, TokensTypes.Llaves.name());
                break;
            case '[',']':
                isToken = isTheLast();
                token = new Token(lexeme, TokensTypes.Corchetes.color, TokensTypes.Corchetes.name());
                break;
            case '.':
                isToken = isTheLast();
                token = new Token(lexeme, TokensTypes.Punto.color, TokensTypes.Punto.name());
                break;
            case ',':
                isToken = isTheLast();
                token = new Token(lexeme, TokensTypes.Coma.color, TokensTypes.Coma.name());
                break;
        }
        return isToken;
    }
}
