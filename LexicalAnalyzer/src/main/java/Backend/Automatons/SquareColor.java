package Backend.Automatons;

import Backend.analyzers.LexicalAnalyzer;
import Backend.Token;

public class SquareColor extends Automaton{

    private static final char [] SQUARE_COLOR = {'q','u','a','r','e','.','C','o','l','o','r','(','#'};
    public static final String NAME = "Square Color";

    private String color = "#";
    private String row;
    private String column;

    @Override
    public boolean validateToken(Token token) {
        this.token = token;
        lexeme = token.getLexeme();
        chars = lexeme.toCharArray();
        try {
            if (chars[current] == 'S'){
                if (isAReservedWord(SQUARE_COLOR)){
                    current ++;
                    if (isACapitalLetter(chars[current]) || isNumber(chars[current])){
                        color += chars[current];
                        color1();
                    }
                }
            }
            System.out.println(color);
        } catch (ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
            System.out.println("retornando false desde color");
            return false;
        }
        return isToken;
    }

    private void color1(){
        current++;
        if (isACapitalLetter(chars[current]) || isNumber(chars[current])){
            color += chars[current];
            color2();
        }
    }
    private void color2(){
        current++;
        if (isACapitalLetter(chars[current]) || isNumber(chars[current])){
            color += chars[current];
            color3();
        }
    }
    private void color3(){
        current++;
        if (isACapitalLetter(chars[current]) || isNumber(chars[current])){
            color += chars[current];
            color4();
        }
    }
    private void color4(){
        current++;
        if (isACapitalLetter(chars[current]) || isNumber(chars[current])){
            color += chars[current];
            color5();
        }
    }
    private void color5(){
        current++;
        if (isACapitalLetter(chars[current]) || isNumber(chars[current])){
            color += chars[current];
            color6();
        }
    }
    private void color6(){
        current++;
        if (chars[current] == ','){
            firsComma();
        } else if (chars[current] == ')' && isTheLast()){
            isToken = true;
            token.authorizeToken(color, NAME, isToken);
        }
    }

    private void firsComma(){
        current++;
        if (isNumber(chars[current])){
            concatRow(chars[current]);
            row();
        }
    }
    private void row(){
        current++;
        if (chars[current] == ','){
            secondComma();
        } else if (isNumber(chars[current])){
            concatRow(chars[current]);
            row();
        }
    }

    private void secondComma(){
        current++;
        if (isNumber(chars[current])){
            concatColumn(chars[current]);
            column();
        }
    }

    private void column(){
        current++;
        if (chars[current] == ')' && isTheLast()){
            isToken = false;
            Token squareToken  = new Token(lexeme, color, NAME, row, column, token.getEditorRow(), token.getEditorColumn());
            LexicalAnalyzer.addSpecialToken(token);
        } else if (isNumber(chars[current])){
            concatColumn(chars[current]);
            column();
        }
    }

    private void concatRow(char c){
        if (row == null){
            row = String.valueOf(c);
        } else{
            row += c;
        }
    }

    private void concatColumn(char c){
        if (column == null){
            column = String.valueOf(c);
        } else{
            column += c;
        }
    }
}



