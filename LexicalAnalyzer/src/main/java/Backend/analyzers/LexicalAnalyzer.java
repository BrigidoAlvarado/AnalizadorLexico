package Backend.analyzers;

import Backend.Automatons.*;
import Backend.PossibleTokenSeparator;
import Backend.Token;
import Frontend.Pixel;

import java.util.ArrayList;

public class LexicalAnalyzer {

    private final PossibleTokenSeparator tokenSeparator = new PossibleTokenSeparator();

    private static ArrayList<Token> specialTokens = new ArrayList<>();

    private ArrayList<String> possibleTokens = new ArrayList<>();
    private ArrayList<Token> squareColorWithAddress = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();
    private Pixel[][] canvas;

    public void analyze(String input, Pixel[][] canvas) {
        specialTokens = new ArrayList<>();
        this.canvas = canvas;
        possibleTokens = tokenSeparator.getPossibleTokens(input);
        addTokensToArrayList();
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
                int row = token.getRow(), column = token.getColumn();
                canvas[row][column].setToken(token,row,column);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("error de token special");
                break;
                //e.printStackTrace();
//                throw new RuntimeException("la posicion fila: " + token.getRow() + ", columna: " + token.getColumn() + " esta fuera de los limites del arreglo");
            }
        }
    }

    private void addTokensToArrayList() {
        for (String possibleToken : possibleTokens) {
            Token token = getToken(possibleToken);
            if (token != null) {
                tokens.add(token);
            }
        }
    }

    private Token getToken(String input) {
        TokenAnalyzer analyzer = new TokenAnalyzer();
        return analyzer.analyzeTokens(0, 0, input);
    }

    public static void addSpecialToken(Token specialToken) {
        specialTokens.add(specialToken);
    }
}
