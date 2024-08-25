package Backend.Enum;

public enum TokensTypes {
    Identificador("#FFD300"),

    //OPERADORES

    //Aritmeticos
    Suma("#FF33FF"),
    Resta("#C1946B"),
    Exponente("#FCD0B4"),
    Division("#B4D941"),
    Modulo("#D9AB41"),
    Multiplicacion("#D80073"),

    //Relacionales o de Comparacion
    Igual("#6A00FF"),
    Diferente("#3F2212"),
    MayorQue("#D9D441"),
    MenorQue("#D94A41"),
    MayorOIgualQue("#E3C800"),
    MenorOIgualQue("#F0A30A"),

    //Logicos
    y("#414ED0"),
    o("#41D95D"),
    negacion("#A741D9")
    ;

    public final String color;

    TokensTypes(String color){
        this.color = color;
    }
}
