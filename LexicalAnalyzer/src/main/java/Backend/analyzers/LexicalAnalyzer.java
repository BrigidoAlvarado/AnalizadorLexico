package Backend.analyzers;

import Backend.PossibleTokenSeparator;
import Backend.Token;
import Frontend.Pixel;

import java.util.ArrayList;

public class LexicalAnalyzer {

    private final PossibleTokenSeparator tokenSeparator = new PossibleTokenSeparator();

    private static ArrayList<Token> specialTokens = new ArrayList<>();

    private ArrayList<Token> possibleTokens = new ArrayList<>();
    private ArrayList<Token> squareColorWithAddress = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();
    private Pixel[][] canvas;

    public void analyze(String input, Pixel[][] canvas) {
        specialTokens = new ArrayList<>();
        this.canvas = canvas;
        possibleTokens = tokenSeparator.getPossibleTokens(input);
        addValidTokens();
        paintCanvas();
        //se pintan los tokens especiales
         System.out.println("iniciando pintar pixeles expeciales");
        paintSpecialsTokens();
        //los pixeles obetenidos son
        System.out.println();
        System.out.println("Los pixeles son guardados son: ");
        for (int row = 0; row < canvas.length; row++) {
            for (int column = 0; column < canvas[row].length; column++) {
                if (canvas[row][column].hasToken()) {
                   System.out.println(canvas[row][column].getToken().getLexeme());
                    System.out.println("linea : "+canvas[row][column].getToken().getEditorRow());
                     System.out.println("columna : "+canvas[row][column].getToken().getEditorColumn());
                }
            }
        }
    }

    private void paintCanvas() {
        int counter = 0;
      
        for (int row = 0; row < canvas.length; row++) {
            for (int column = 0; column < canvas[row].length; column++) {
                try {
                    canvas[row][column].setToken(tokens.get(counter), row, column);
                    counter++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }
    }

    private void paintSpecialsTokens() {
        for (Token token : specialTokens) {
            try {
                int row = token.getPixelRow(), column = token.getPixelColumn();
                canvas[row][column].setToken(token,row,column);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("error de token special");
                break;
                //e.printStackTrace();
//                throw new RuntimeException("la posicion fila: " + token.getRow() + ", columna: " + token.getColumn() + " esta fuera de los limites del arreglo");
            }
        }
    }

    private void addValidTokens() {
        for (Token possibleToken : possibleTokens) {
            if (validateToken(possibleToken)) {
                tokens.add(possibleToken);
            }
        }
    }

    private boolean validateToken(Token input) {
        TokenAnalyzer analyzer = new TokenAnalyzer();
        return analyzer.analyzeTokens(input);
    }

    public static void addSpecialToken(Token specialToken) {
        specialTokens.add(specialToken);
    }
}
