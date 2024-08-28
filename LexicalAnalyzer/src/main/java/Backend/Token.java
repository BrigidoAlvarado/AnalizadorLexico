package Backend;

public class Token {
    private int column;
    private int row;
    private String lexeme;
    private String kind;
    private String color;

    public Token (String lexeme, String color, String kind, int row, int column) {
        this.lexeme = lexeme;
        this.color = color;
        this.kind = kind;
        this.row = row;
        this.column = column;
        System.out.println("se  creo la clase con "+this.row+" "+column);
    }

    public Token (String lexeme, String color, String kind) {
        this.lexeme = lexeme;
        this.color = color;
        this.kind = kind;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
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
}
