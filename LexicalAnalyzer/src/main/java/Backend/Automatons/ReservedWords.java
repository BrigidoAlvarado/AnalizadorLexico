package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

public class ReservedWords extends Automaton{

    public static final char [] BOOLEAN = {'o','o','l','e','a','n'},
            CHAR = {'a','r'},
            CONS = {'n','s'},
            WRITE = {'r','i','t','e'},
    READ = {'e','a','d'},
    LINE = {'L','i','n','e'},
    OLE_POINT = {'o','l','e','.'},
    DOUBLE = {'u','b','l','e'};



    @Override
    public boolean isToken(String string) {
        lexeme = string;
        chars = lexeme.toCharArray();

        switch (chars[current]){
            case 'A':
                current++;
                if ( isTheLast() && chars[current] == 's'){
                    isToken = true;
                }
                break;
            case 'B':
                isToken = isAReservedFinalWord(BOOLEAN);
                break;
            case 'C':
                current ++;
                switch (chars[current]){
                    case 'h':
                        System.out.println(chars[current]);
                        if (isAReservedFinalWord(CHAR)){
                            isToken = true;
                        }
                        break;
                    case 'o':
                        if (isAReservedWord(CONS)){
                            System.out.println("entro");
                            if (chars[current + 1] == 't'){
                                isToken = true;
                            } else if (isAReservedWord(OLE_POINT)){
                                if (isAReservedWord(WRITE) || isAReservedFinalWord(READ)){
                                    if (isAReservedFinalWord(LINE)){
                                        isToken = true;
                                    }
                                }
                            }
                        }
                        break;
                }
                break;
            case 'D':
                current++;
                switch (chars[current]){
                    case 'i':
                        current ++;
                        isToken = chars[current] == 'm';
                        break;
                    case 'o':
                        isToken = isAReservedFinalWord(DOUBLE);
                        break;
                }
                break;
        }
        return isToken;
    }

    @Override
    public Token getToken(int row, int column){
        return  new Token(lexeme, TokensTypes.Palabra_Reservada.color, TokensTypes.Palabra_Reservada.name(), row, column);
    }
}
