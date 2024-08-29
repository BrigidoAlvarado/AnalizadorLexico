package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class SignsAndSymbols extends Automaton {
    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();
        switch (chars[current]) {
            case '(',')':
                isToken = isTheLast();
                token.authorizeToken(TokensTypes.Parentesis.color, TokensTypes.Parentesis.name(), isToken);
                break;
            case '{','}':
                isToken = isTheLast();
                token.authorizeToken(TokensTypes.Llaves.color, TokensTypes.Llaves.name(), isToken);
                break;
            case '[',']':
                isToken = isTheLast();
                token.authorizeToken(TokensTypes.Corchetes.color, TokensTypes.Corchetes.name(), isToken);
                break;
            case '.':
                isToken = isTheLast();
                token.authorizeToken(TokensTypes.Punto.color, TokensTypes.Punto.name(),isToken);
                break;
            case ',':
                isToken = isTheLast();
                token.authorizeToken(TokensTypes.Coma.color, TokensTypes.Coma.name(), isToken);
                break;
        }
        return isToken;
    }
}
