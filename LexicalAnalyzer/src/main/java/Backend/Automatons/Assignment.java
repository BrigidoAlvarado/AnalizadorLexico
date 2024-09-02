package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class Assignment extends Automaton{

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();

        try {
            if (chars[current] == '='){
                equalsCase();
                token.authorizeToken(TokensTypes.Asiganacion_Simple.color, TokensTypes.Asiganacion_Simple.name(),isToken);
            } else if (chars[current] == '+' || chars[current] == '-'
                    || chars[current] == '*' || chars[current] == '/'){
                current ++;
                equalsCase();
                token.authorizeToken(TokensTypes.Asignacion_Compuesta.color, TokensTypes.Asignacion_Compuesta.name(), isToken);
            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private void equalsCase(){
        isToken = (isTheLast() && (chars[current] == '='));
    }
}
