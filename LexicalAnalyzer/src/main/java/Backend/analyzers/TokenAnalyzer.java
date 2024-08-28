/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.analyzers;

import Backend.Automatons.ArithmeticOperator;
import Backend.Automatons.Assignment;
import Backend.Automatons.DataTypes;
import Backend.Automatons.Identifier;
import Backend.Automatons.Logical;
import Backend.Automatons.RationalCoparison;
import Backend.Automatons.ReservedWords;
import Backend.Automatons.SignsAndSymbols;
import Backend.Automatons.SquareColor;
import Backend.Token;

/**
 *
 * @author brigidoalvarado
 */
public class TokenAnalyzer {
    
    private final Identifier identifier = new Identifier();
    private final ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
    private final RationalCoparison rationalCoparison = new RationalCoparison();
    private final Logical logical = new Logical();
    private final Assignment assignment = new Assignment();
    private final ReservedWords reservedWords = new ReservedWords();
    private final DataTypes dataTypes = new DataTypes();
    private final SignsAndSymbols signsAndSymbols = new SignsAndSymbols();
    private final SquareColor squareColor = new SquareColor();
    
    
    public Token analyzeTokens(int row, int column, String input) {
        Token token = null;
        if (signsAndSymbols.isToken(input)) {
            token = signsAndSymbols.getToken();
        } else if (dataTypes.isToken(input)) {
            token = dataTypes.getToken();
        } else if (arithmeticOperator.isToken(input)) {
            token = arithmeticOperator.getToken();
        } else if (rationalCoparison.isToken(input)) {
            token = rationalCoparison.getToken();
        } else if (logical.isToken(input)) {
            token = logical.getToken();
        } else if (assignment.isToken(input)) {
            token = assignment.getToken();
        } else if (reservedWords.isToken(input)) {
            token = reservedWords.getToken();
        } else if (identifier.isToken(input)) {
            token = identifier.getToken();
        } else if (squareColor.isToken(input)) {
            token = squareColor.getToken();
        }
        return token;
    }
}
