import Backend.LexicalAnalyzer;
import Frontend.AnalyzerApp;

public class Main {
    public static void main(String[] args) {
        //LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        //lexicalAnalyzer.analyzeTokens(0,0);
            //AnalyzerApp analyzerApp = new AnalyzerApp();
            //analyzerApp.setVisible(true);
        int [][] tablero = new int[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = i+j;
            }
        }

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}