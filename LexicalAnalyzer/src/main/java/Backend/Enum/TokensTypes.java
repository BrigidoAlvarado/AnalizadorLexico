package Backend.Enum;

public enum TokensTypes {
    Identificador("#FFD300"),

    //OPERATORS

    //Arithmetics
    Suma("#FF33FF"),
    Resta("#C1946B"),
    Exponente("#FCD0B4"),
    Division("#B4D941"),
    Modulo("#D9AB41"),
    Multiplicacion("#D80073"),

    //Relational or of Comparison
    Igual("#6A00FF"),
    Diferente("#3F2212"),
    Mayor_Que("#D9D441"),
    Menor_Que("#D94A41"),
    Mayor_o_Igual_Que("#E3C800"),
    Menor_o_Igual_Que("#F0A30A"),

    //Logics
    y("#414ED0"),
    o("#41D95D"),
    negacion("#A741D9"),

    //Assignment
    Asiganacion_Simple("#41D9D4"),
    Asignacion_Compuesta("#FFFFFF"),

    //Reserved Words
    Palabra_Reservada("#60A917")
    ;

    public final String color;

    TokensTypes(String color){
        this.color = color;
    }

}
