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
    
    
    public boolean analyzeTokens(Token  token) {
        if (signsAndSymbols.validateToken(token)) {
           return true;
        } else if (reservedWords.validateToken(token)) {
            return true;
        } else if (dataTypes.validateToken(token)) {
             return true;
        } else if (arithmeticOperator.validateToken(token)) {
             return true;
        } else if (rationalCoparison.validateToken(token)) {
             return true;
        } else if (logical.validateToken(token)) {
             return true;
        } else if (assignment.validateToken(token)) {
             return true;
        }   else if (identifier.validateToken(token)) {
             return true;
        }else return squareColor.validateToken(token);
    }
}
