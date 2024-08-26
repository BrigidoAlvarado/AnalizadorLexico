package Backend.Automatons;

import Backend.Enum.TokensTypes;
import Backend.Token;

import java.lang.reflect.Array;

public class ReservedWords extends Automaton{

    public static final char []
            BOOLEAN = {'o','o','l','e','a','n'},
            CHAR = {'a','r'},
            CONS = {'n','s'},
            WRITE = {'r','i','t','e'},
            READ = {'e','a','d'},
            LINE = {'L','i','n','e'},
            OLE_POINT = {'l','e','.'},
            DOUBLE = {'u','b','l','e'},
            ELSE = {'s','e'},
            FUNCTION = {'u','n','c','t','i','o','n'},
            IF = {'I','f'},
            INTEGER = {'n','t','e','g','e','r'},
            LOOP = {'o','o','p'},
            MAIN = {'i','n'},
            MODULE = {'d','u','l','e'},
            NEXT = {'e','x','t'},
            RETURN = {'e','t','u','r','n'},
            STRING = {'r','i','n','g'},
            THEN = {'e','n'},
            WHILE = {'h','i','l','e'};



    @Override
    public boolean isToken(String string) {
        lexeme = string;
        chars = lexeme.toCharArray();

        try {
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
                                current ++;
                                switch (chars[current]){
                                    case 't':
                                        isToken = true;
                                        break;
                                    case 'o':
                                        if (isAReservedWord(OLE_POINT)){
                                            current++;
                                            switch (chars[current]){
                                                case 'W':
                                                    if (isAReservedWord(WRITE)){
                                                        System.out.println("entro");
                                                        isToken = isAReservedFinalWord(LINE);
                                                    }
                                                    break;
                                                case 'R':
                                                    if (isAReservedWord(READ)){
                                                        isToken = isAReservedFinalWord(LINE);
                                                    }
                                                    break;
                                            }
                                        }
                                        break;

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
                case 'E':
                    current ++;
                    switch (chars[current]){
                        case 'l':
                            if (isAReservedWord(ELSE)){
                                if (isTheLast()){
                                    isToken = true;
                                } else if (isAReservedFinalWord(IF)){
                                    isToken = true;
                                }
                            }
                            break;
                        case 'n':
                            current++;
                            isToken = isTheLast() && chars[current] == 'd';
                            break;
                    }
                    break;
                case 'F':
                    if (chars[current + 1] == 'o'){
                        current ++;
                        current ++;
                        isToken = isTheLast() && chars[current] == 'r';
                    } else if (isAReservedFinalWord(FUNCTION)){
                        isToken = true;
                    }
                    break;
                case 'I':
                    if (chars[current + 1] == 'f'){
                        current ++;
                        isToken = isTheLast();
                    } else if (isAReservedFinalWord(INTEGER)){
                        isToken = true;
                    }
                    break;
                case 'L':
                    isToken = isAReservedFinalWord(LOOP);
                    break;
                case 'M':
                    current++;
                    switch (chars[current]){
                        case 'a':
                            isToken = isAReservedFinalWord(MAIN);
                            break;
                        case 'o':
                            isToken = isAReservedFinalWord(MODULE);
                            break;
                    }
                    break;
                case 'N':
                    isToken = isAReservedFinalWord(NEXT);
                    break;
                case 'R':
                    isToken = isAReservedFinalWord(RETURN);
                    break;
                case 'S':
                    current ++;
                    switch (chars[current]){
                        case 't':
                            isToken = isAReservedFinalWord(STRING) && isTheLast();
                            break;
                        case 'u':
                            current++;
                            isToken = (chars[current] == 'b' && isTheLast());
                            break;
                    }
                    break;
                case 'T':
                    current ++;
                    switch (chars[current]){
                        case 'h':
                            isToken = isAReservedFinalWord(THEN);
                            break;
                        case 'o':
                            isToken = isTheLast();
                            break;
                    }
                    break;
                case 'W':
                    isToken = isAReservedFinalWord(WHILE);
                    break;
            }
            return isToken;
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("retornanado un false");
            return false;
        }
    }

    @Override
    public Token getToken(int row, int column){
        return  new Token(lexeme, TokensTypes.Palabra_Reservada.color, TokensTypes.Palabra_Reservada.name(), row, column);
    }
}
