package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class Logical extends Automaton {

    private static final char [] AND = {'n','d'};
    private static final char [] OR = {'r'};
    private static final char [] NOT = {'o','t'};

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();
        try {
            switch (chars[0]) {
                case 'A' -> isAnd();
                case 'O' -> isOr();
                case 'N' -> isNot();
                default -> isToken = false;

            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private void isAnd(){
        current = 0;
        if ( isAReservedFinalWord(AND)) {
                isToken = true;
                token.authorizeToken(TokensTypes.y.color, TokensTypes.y.name(), isToken);
            }
    }

    private void isOr (){
        current = 0;
        if ( isAReservedFinalWord(OR)) {
                isToken = true;
                token.authorizeToken(TokensTypes.o.color, TokensTypes.o.name(), isToken);
            }  
    }

    private void isNot(){
        current = 0;
        if ( isAReservedFinalWord(NOT)) {
                isToken = true;
                token.authorizeToken(TokensTypes.negacion.color, TokensTypes.negacion.name(), isToken);
            }
    }

}
