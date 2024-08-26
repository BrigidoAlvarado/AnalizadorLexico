package Backend;

import Backend.Automatons.*;

import java.util.ArrayList;

public class LexicalAnalyzer {

    private String[] words;
    private ArrayList<Token> tokens;
    private final Identifier identifier = new Identifier();
    private final ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
    private final RationalCoparison rationalCoparison = new RationalCoparison();
    private final Logical logical = new Logical();
    private final Assignment assignment = new Assignment();
    private final ReservedWords reservedWords = new ReservedWords();


    String prueba = "W";
    Token token;
    public void analyzeTokens(int row, int column){

        if (arithmeticOperator.isToken(prueba)){
            token = arithmeticOperator.getToken(column,row);
        }else if (rationalCoparison.isToken(prueba)){
            token = rationalCoparison.getToken(column,row);
        } else if (logical.isToken(prueba)) {
            token = logical.getToken(column,row);
        } else if (assignment.isToken(prueba)){
            token = assignment.getToken(column,row);
        } else if (reservedWords.isToken(prueba)){
            token = reservedWords.getToken(column,row);
        } else if (identifier.isToken(prueba)){
            token = identifier.getToken(row,column);
        }
        System.out.println(token.getLexeme());
        System.out.println(token.getKind());
        System.out.println(token.getColor());
    }
}
