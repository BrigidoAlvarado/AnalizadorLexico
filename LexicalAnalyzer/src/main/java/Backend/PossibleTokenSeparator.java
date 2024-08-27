package Backend;

import java.util.ArrayList;

public class PossibleTokenSeparator {

    public static final char VOID = ' ';
    public static final char LINE_BREAK = '\n';
    private static final char TAB = '\t';

    private final ArrayList<String> possibleTokens = new ArrayList<>();
    private char[] chars;
    private int current = 0;
    private String possibleToken;

    public ArrayList<String> getPossibleTokens(String imput) {
        chars = imput.toCharArray();
        stateCero();
        return possibleTokens;
    }

    private void stateCero() {
        if (current < (chars.length)) {
            if (chars[current] == VOID || chars[current] == LINE_BREAK || chars[current] == TAB) {
                voidOrBreakLine();
            } else if (chars[current] == '\'') {
                stringBuider(chars[current]);
                quotation();
            } else {
                stringBuider(chars[current]);
                symbols();
            }
        }
    }

    private void symbols() {
        current++;
        if (current < (chars.length)) {
            if (chars[current] == VOID || chars[current] == LINE_BREAK || chars[current] == TAB) {
               savePossibletoken();
                voidOrBreakLine();
            } else {
                stringBuider(chars[current]);
                symbols();
            }
        } else {
            savePossibletoken();
        }
    }

    private void voidOrBreakLine() {
        current++;
        if (current < (chars.length)) {
            if (chars[current] == LINE_BREAK || chars[current] == VOID || chars[current] == TAB) {
                savePossibletoken();
                voidOrBreakLine();
            } else if (chars[current] == '\'') {
                stringBuider(chars[current]);
                quotation();
            } else {
                stringBuider(chars[current]);
                symbols();
            }
        } else {
            savePossibletoken();
        }
    }

    private void quotation() {
        current++;
        if (current < (chars.length)) {
            if (chars[current] == LINE_BREAK) {
                savePossibletoken();
                voidOrBreakLine();
            } else {
                stringBuider(chars[current]);
                quotation();
            }
        } else {
            savePossibletoken();
        }
    }

    private void stringBuider(char c) {
        if (possibleToken == null) {
            possibleToken = String.valueOf(c);
        } else {
            possibleToken += c;
        }
    }
    
    private void savePossibletoken(){
        if (possibleToken != null) {
            possibleTokens.add(possibleToken);
            possibleToken = null;
        }
    }
}
