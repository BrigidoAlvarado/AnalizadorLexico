package Backend.analyzers;

import Backend.PossibleTokenSeparator;
import Backend.Token;
import Frontend.AnalyzerApp;
import Frontend.Pixel;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LexicalAnalyzer {

    private final PossibleTokenSeparator tokenSeparator = new PossibleTokenSeparator();

    private static ArrayList<Token> specialTokens = new ArrayList<>();

    private ArrayList<Token> possibleTokens = new ArrayList<>();
    private ArrayList<Token> squareColorWithAddress = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();
    private Pixel[][] canvas;
    private AnalyzerApp app;

    public void analyze(String input, Pixel[][] canvas, AnalyzerApp app) {
        this.app = app;
        specialTokens = new ArrayList<>();
        this.canvas = canvas;
        possibleTokens = tokenSeparator.getPossibleTokens(input, app);
        addValidTokens();
        paintCanvas();
        paintSpecialsTokens();
        //los pixeles obetenidos son
        System.out.println();
        System.out.println("Los pixeles guardados son: ");
        for (int row = 0; row < canvas.length; row++) {
            for (int column = 0; column < canvas[row].length; column++) {
                if (canvas[row][column].hasToken()) {
                    System.out.println(canvas[row][column].getToken().getLexeme());
                    System.out.println("linea : " + canvas[row][column].getToken().getEditorRow());
                    System.out.println("columna : " + canvas[row][column].getToken().getEditorColumn());
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
                canvas[row][column].setToken(token, row, column);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(app, "La posicion asignada al token especial: "+ token.getLexeme() +"\n es mayor al tamaño del lienzo", "Token especial linea: "+token.getEditorRow()+" Columna: "+token.getEditorColumn(), JOptionPane.INFORMATION_MESSAGE);
                break;
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
