package Backend;

import Backend.Automatons.Automaton;
import java.util.ArrayList;

public class PossibleTokenSeparator {

    public static final char VOID = ' ';
    public static final char LINE_BREAK = '\n';
    private static final char TAB = '\t';

    private final ArrayList<Token> possibleTokens = new ArrayList<>();
    private char[] chars;
    private int current = 0;
    private int line = 1;
    private int column = 0;
    private String possibleToken;

    public ArrayList<Token> getPossibleTokens(String imput) {
        chars = imput.toCharArray();
        stateCero();
        return possibleTokens;
    }

    private void stateCero() {
        if (current < (chars.length)) {
            
            if (chars[current] == VOID || chars[current] == LINE_BREAK || chars[current] == TAB) {
                increaseCounters();
                voidOrBreakLine();
            } else if (chars[current] == '\'') {
                increaseCounters();
                stringBuider(chars[current]);
                quotation();
            } else {
                increaseCounters();
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
                increaseCounters();
                voidOrBreakLine();
            } else {
                increaseCounters();
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
                increaseCounters();
                voidOrBreakLine();
            } else if (chars[current] == '\'') {
                increaseCounters();
                stringBuider(chars[current]);
                quotation();
            } else {
                increaseCounters();
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
                increaseCounters();
                voidOrBreakLine();
            } else if (Automaton.isLetterOrCapitalLetter(chars[current])) {
                increaseCounters();
                stringBuider(chars[current]);
                caracter();
            } else {
                increaseCounters();
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

    private void savePossibletoken() {
        if (possibleToken != null) {
            possibleTokens.add(new Token(line, column, possibleToken));
            possibleToken = null;
        }
    }

    private void caracter() {
        current++;
        if (current < chars.length) {
        
            if (chars[current] == '\'') {
                increaseCounters();
                stringBuider(chars[current]);
                endQuotation();
            } else if (chars[current] == LINE_BREAK) {
                savePossibletoken();
            } else {
                increaseCounters();
                stringBuider(chars[current]);
                comentContent();
            }
        } else {
            savePossibletoken();
        }
    }

    private void endQuotation() {
        current++;
        if (current < chars.length) {
        
            if (chars[current] == VOID || chars[current] == LINE_BREAK) {
                savePossibletoken();
                increaseCounters();
                voidOrBreakLine();
            } else {
                increaseCounters();
                stringBuider(chars[current]);
                comentContent();
            }
        } else {
            savePossibletoken();
        }
    }

    private void comentContent() {
        current++;
        if (current < chars.length) {
        
            if (chars[current] == LINE_BREAK) {
                savePossibletoken();
                increaseCounters();
                voidOrBreakLine();
            } else {
                increaseCounters();
                stringBuider(chars[current]);
                comentContent();
            }
        } else {
            savePossibletoken();
        }
    }

    private void increaseCounters() {
        if (chars.length != 0) {
            char c = chars[current];
            if (c == LINE_BREAK) {
                column = 0;
                line++;
            } else {
                column++;
            }
        }

    }
}
