package Backend;

import Backend.Automatons.ArithmeticOperator;
import Backend.Automatons.Identifier;
import Backend.Automatons.RationalCoparison;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class LexicalAnalyzer {
    private String[] words;
    private ArrayList<Token> tokens;

    private final Identifier identifier = new Identifier();
    private final ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
    private final RationalCoparison rationalCoparison = new RationalCoparison();


    String prueba = ">-=";
    Token token;
    public void analyzeTokens(){

        if (arithmeticOperator.isToken(prueba)){
            token = arithmeticOperator.getToken(0,0);
        } else if (identifier.isToken(prueba)){
            token = identifier.getToken(0,0);
        } else if (rationalCoparison.isToken(prueba)){
            token = rationalCoparison.getToken(0,0);
        }
        System.out.println(token.getKind());
        System.out.println(token.getColor());
    }
}
