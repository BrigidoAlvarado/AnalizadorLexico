package Backend;

import java.util.ArrayList;
import java.util.Calendar;

public class possibleTokenSeparator {
    public static final char VOID = ' ';
    public static final char LINE_BREAK = '\n';

    private ArrayList<String> possibleTokens = new ArrayList<>();
    private char [] chars;
    private int current = 0;
    private String possibleToken;

    public ArrayList<String> getPossibleTokens(String imput) {
        chars = imput.toCharArray();
        if (chars[current] == VOID && chars[current] == LINE_BREAK) {
            voidOrBreakLine();
        } else if (chars[current] == '\''){
            quotation();
        } else{
            symbols();
        }
        return possibleTokens;
    }

    private void symbols(){
        current ++;

    }

    private void voidOrBreakLine(){
        current++;
    }

    private void quotation(){
        current++;
    }

    private boolean end(){
        return current == (chars.length -1);
    }
}
