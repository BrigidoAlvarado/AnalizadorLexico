package Backend;

import Frontend.AnalyzerApp;

public class Token {
    private int pixelColumn;
    private int pixelRow;
    private int editorColumn;
    private int editorRow;
    private String lexeme;
    private String kind;
    private String color;
    private boolean isToken = false;
    private AnalyzerApp app;
    
    public Token ( int editorRow, int editorColumn, String lexeme, AnalyzerApp app){
        this.app = app;
        this.editorColumn = editorColumn;
        this.editorRow = editorRow;
        this.lexeme = lexeme;
    }

    public Token (String lexeme, String color, String name, String pixelRow, String pixelColumn, int editorRow, int editorColumn){
        System.out.println(pixelRow+" "+pixelColumn);
        this.lexeme = lexeme;
        this.color = color;
        this.pixelRow = Integer.parseInt(pixelRow);
        this.pixelColumn = Integer.parseInt(pixelColumn);
        this.editorRow = editorRow;
        this.editorColumn = editorColumn;
    }

    public void authorizeToken  (String color, String kind, boolean isToken){
        this.isToken = isToken;
        this.color = color;
        this.kind = kind;
    }

    public void setPixelColumn(int column) {
        this.pixelColumn = column;
    }

    public void setPixelRow(int row) {
        this.pixelRow = row;
    }
    
    public int getPixelColumn() {
        return pixelColumn;
    }

    public int getPixelRow() {
        return pixelRow;
    }
    
     public int getEditorColumn() {
        return editorColumn;
    }

    public int getEditorRow() {
        return editorRow;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String getKind() {
        return kind;
    }

    public String getColor() {
        return color;
    }

    public boolean isToken() {
        return isToken;
    }
    
    public AnalyzerApp getApp(){
        return  app;
    }
}
