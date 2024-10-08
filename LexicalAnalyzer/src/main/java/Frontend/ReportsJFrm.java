/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.Token;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brigidoalvarado
 */
public class ReportsJFrm extends javax.swing.JFrame {
    
    DefaultTableModel tableModel;
    JTable reportsTable; 
   
    public ReportsJFrm(ArrayList<Token> reports) {
        initComponents();
        initTable();
        setDataCard(reports);
    }

    private void initTable(){
       String[] column = {
           "            Token           ", "                Lexema           ", "Linea", "Columna", "                Cuadro              "
       };
       tableModel = new DefaultTableModel(column, 0);
        reportsTable = new JTable(tableModel);
       JScrollPane jScrollPane = new JScrollPane(reportsTable);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
       jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jScrollPane);
   }
    
    private void setDataCard(ArrayList<Token>  tokens){
        
        for (Token token : tokens) {
             JPanel color = new JPanel();
             color.setBackground(Color.decode(token.getColor()));
             Object [ ] row = {
             token.getKind(), token.getLexeme(), token.getEditorRow(), token.getEditorColumn(), 
             "Fila: "+token.getPixelRow()+"\n"
                     + " Columna: "+token.getPixelColumn()+"\n"
                     + " Color: "+token.getColor()};
             tableModel.addRow(row);
         }
         int rowHeight = reportsTable.getRowHeight();
        int totalHeight = rowHeight * reportsTable.getRowCount();
        reportsTable.setPreferredScrollableViewportSize(new Dimension(reportsTable.getPreferredSize().width, totalHeight));
         this.pack();
         this.repaint();
         this.revalidate();
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
