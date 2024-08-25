package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class Assignment extends Automaton{
    @Override
    public boolean isToken(String string) {
        lexeme = string;
        chars = lexeme.toCharArray();

        if (chars[current] == '='){
            token = new Token(lexeme, TokensTypes.Asiganacion_Simple.color, TokensTypes.Asiganacion_Simple.name());
            equalsCase();
        } else if (chars[current] == '+' || chars[current] == '-'
                || chars[current] == '*' || chars[current] == '/'){
            token = new Token(lexeme, TokensTypes.Asignacion_Compuesta.color, TokensTypes.Asignacion_Compuesta.name());
            current ++;
            equalsCase();
        }
        return isToken;
    }

    private void equalsCase(){
        isToken = (isTheLast() && (chars[current] == '='));
    }
}
