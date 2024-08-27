package Backend;

import Backend.Automatons.*;
import Frontend.Pixel;

import java.util.ArrayList;

public class LexicalAnalyzer {

    private final Identifier identifier = new Identifier();
    private final ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
    private final RationalCoparison rationalCoparison = new RationalCoparison();
    private final Logical logical = new Logical();
    private final Assignment assignment = new Assignment();
    private final ReservedWords reservedWords = new ReservedWords();
    private final DataTypes dataTypes = new DataTypes();
    private final SignsAndSymbols signsAndSymbols = new SignsAndSymbols();
    private final SquareColor squareColor = new SquareColor();
    private  PossibleTokenSeparator tokenSeparator = new PossibleTokenSeparator();
    
     private ArrayList<String> possibleTokens;
    private ArrayList<Token> tokens;
    private ArrayList<Token>  squareColorWithAddress;
    private Pixel [][] canvas;

    String prueba = "Square.Color(#123456,9,2)";
    Token token;

    public void analyzeTokens(int row, int column){

        if (signsAndSymbols.isToken(prueba)){
            token = signsAndSymbols.getToken(row,column);
        } else if (dataTypes.isToken(prueba)){
            token = dataTypes.getToken(row,column);
        } else if (arithmeticOperator.isToken(prueba)){
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
        } else if (squareColor.isToken(prueba)){
            token = squareColor.getToken(column,row);
        }
        System.out.println(token.getLexeme());
        System.out.println(token.getKind());
        System.out.println(token.getColor());
    }

    public void analyze(String input, Pixel[][] canvas ){
        System.out.println("en analyze ");
        possibleTokens = tokenSeparator.getPossibleTokens(input);
        System.out.println("el arreglo es de tamanio  "+possibleTokens.size());
        for (String possibleToken : possibleTokens) {
            char[] c = possibleToken.toCharArray();
            System.out.println("el tamanio del la palabra es de: " + c.length );
            System.out.println(" este es un possible token  "+possibleToken);
        }
    }
}
