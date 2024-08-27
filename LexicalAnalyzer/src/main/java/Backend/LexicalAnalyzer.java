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
    private final PossibleTokenSeparator tokenSeparator = new PossibleTokenSeparator();

    private static ArrayList<Token> specialTokens = new ArrayList<>();

    private ArrayList<String> possibleTokens;
    private ArrayList<Token> tokens;
    private ArrayList<Token>  squareColorWithAddress;
    private Pixel [][] canvas;

    String prueba = "Square.Color(#123456)";
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
        if (token != null){
            System.out.println(token.getLexeme());
            System.out.println(token.getKind());
            System.out.println(token.getColor());
        }
        System.out.println(specialTokens.size());
    }

    public void analyze(String input, Pixel[][] canvas ){
        this.canvas = canvas;
        possibleTokens = tokenSeparator.getPossibleTokens(input);
    }

    private void paintCanvas(){
        //for ()
    }

    public static void addSpecialToken(Token specialToken){
        specialTokens.add(specialToken);
    }
}
