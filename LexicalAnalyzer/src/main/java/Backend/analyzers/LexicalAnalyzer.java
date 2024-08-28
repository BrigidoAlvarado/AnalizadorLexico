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
        // se inicia el tablero
        this.canvas = canvas;
        //se iniciar un arreglo de posible tokens
        //se extraen los posibles tokens
        possibleTokens = tokenSeparator.getPossibleTokens(input);
        System.out.println();
        System.out.println("los posibles tokens son:");
        for (String token : possibleTokens) {
            System.out.println(token);
        }
        System.out.println();
        // se crea un arreglo de tokens
        addTokensToArrayList();
        System.out.println("estos son los token encontrados");
        for (Token token : tokens) {
            System.out.println(token.getLexeme());                
        }

        //se pintan los pixeles
        System.out.println("iniciando a pintar pixeles...");
        paintCanvas();
        System.out.println("estos son los pixeles guardados");
        for (Pixel[] canva : canvas) {
            for (Pixel pixel : canva) {
                System.out.println(pixel);
                if (pixel.hasToken()) {
                   System.out.println(pixel.getToken().getLexeme());                    
                }
            }
        }

        //se pintan los tokens especiales
        // System.out.println("iniciando pintar pixeles expeciales");
        //paintSpecialsTokens();
        //los pixeles obetenidos son
//        System.out.println();
//        System.out.println("Los pixeles son: ");
//        for (int row = 0; row < canvas.length; row++) {
//            for (int column = 0; column < canvas[row].length; column++) {
//                System.out.println(canvas[row][column].getToken().getLexeme());
//                System.out.println(canvas[row][column].getToken().getColor());
//            }
//            System.out.println();
//        }
    }

    private void paintCanvas() {
        int counter = 0;
        for (Pixel[] canva : canvas) {
            for (Pixel pixel : canva) {
                try {
                    pixel.setToken(tokens.get(counter));
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
                canvas[row][column].setToken(token);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("error de token special");
                e.printStackTrace();
                throw new RuntimeException("la posicion fila: " + token.getRow() + ", columna: " + token.getColumn() + " esta fuera de los limites del arreglo");
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
