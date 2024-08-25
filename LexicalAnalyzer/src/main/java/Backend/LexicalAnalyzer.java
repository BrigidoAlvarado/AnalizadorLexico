package Backend;

import Backend.Automatons.ArithmeticOperator;
import Backend.Automatons.Identifier;
import Backend.Automatons.Logical;
import Backend.Automatons.RationalCoparison;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class LexicalAnalyzer {
    private String[] words;
    private ArrayList<Token> tokens;

    private final Identifier identifier = new Identifier();
    private final ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
    private final RationalCoparison rationalCoparison = new RationalCoparison();
    private final Logical logical = new Logical();


    String prueba = "not";
    Token token;
    public void analyzeTokens(int row, int column){

        if (arithmeticOperator.isToken(prueba)){
            token = arithmeticOperator.getToken(column,row);
        }else if (rationalCoparison.isToken(prueba)){
            token = rationalCoparison.getToken(column,row);
        } else if (logical.isToken(prueba)) {
            token = logical.getToken(column,row);
        } else if (identifier.isToken(prueba)){
            token = identifier.getToken(row,column);
        }
        System.out.println(token.getKind());
        System.out.println(token.getColor());
    }
}
