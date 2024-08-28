/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.Token;

import java.awt.*;

import static java.awt.Color.decode;

/**
 *
 * @author brigidoalvarado
 */
public class Pixel extends javax.swing.JButton{
    
    private Token token;
    private boolean hasToken = false;

    public void setToken(Token token, int row, int column){
        hasToken = true;
        this.token = token;
        this.token.setRow(row);
        this.token.setColumn(column);
        this.setBackground(Color.decode(token.getColor()));
    }
    
    public void setToken(Token token){
        hasToken = true;
        this.token = token;
        this.setBackground(Color.decode(token.getColor()));
    }

    public boolean hasToken(){
        return  hasToken;
    }
    
    public Token getToken(){
        return token;
    }
}
