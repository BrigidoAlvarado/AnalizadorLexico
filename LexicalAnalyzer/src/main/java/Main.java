import Backend.LexicalAnalyzer;

public class Main {
    public static void main(String[] args) {
        //LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        //lexicalAnalyzer.analyzeTokens();

        int cont = 0;
        char[] chars = {'A','n','d'};
        char[] prueba = {'A','n','d'};

        for (char c : chars) {

            if (cont == (chars.length - 1) && c == prueba[cont]) {
                System.out.println("La palabra si es un token");
            } else  if (c == prueba[cont]) {
                cont++;
            } else {
                System.out.println("la palabra no es un token");
            }
        }
    }
}