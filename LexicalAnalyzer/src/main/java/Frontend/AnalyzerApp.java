/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package Frontend;

import Backend.Token;
import Backend.analyzers.LexicalAnalyzer;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author brigidoalvarado
 */
public class AnalyzerApp extends javax.swing.JFrame {

    private ArrayList<Token> tokensReports = new ArrayList<>();
    private LexicalAnalyzer lexicalAnalyzer;
    private Pixel[][] canvas;

    /**
     * Creates new form AnalyzerApp
     */
    public AnalyzerApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorContainer = new javax.swing.JPanel();
        chargeFilejBttn = new javax.swing.JButton();
        inputjScrllPn = new javax.swing.JScrollPane();
        inputjTxtAr = new javax.swing.JTextArea();
        positionjLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rowNumberjLbl = new javax.swing.JLabel();
        rowNumberjTxtFld = new javax.swing.JTextField();
        columnNumberjLbl = new javax.swing.JLabel();
        columnNumberjTxtFld = new javax.swing.JTextField();
        deletejBttn = new javax.swing.JButton();
        containerCanvasjPnl = new javax.swing.JPanel();
        jMnBr = new javax.swing.JMenuBar();
        OptionsjMn = new javax.swing.JMenu();
        reportsjMnItm = new javax.swing.JMenuItem();
        optionsjSprtr = new javax.swing.JPopupMenu.Separator();
        exportImgjMnItm = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        editorContainer.setBackground(new java.awt.Color(204, 204, 255));
        editorContainer.setForeground(new java.awt.Color(204, 204, 255));

        chargeFilejBttn.setText("Importar Archivo Fuente");
        chargeFilejBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeFilejBttnActionPerformed(evt);
            }
        });

        inputjTxtAr.setColumns(20);
        inputjTxtAr.setRows(5);
        inputjTxtAr.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inputjTxtArCaretUpdate(evt);
            }
        });
        inputjScrllPn.setViewportView(inputjTxtAr);

        positionjLbl.setText("linea :1 columna: 1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tamaño del Lienzo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0)))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        rowNumberjLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rowNumberjLbl.setText("Filas");
        jPanel1.add(rowNumberjLbl);

        rowNumberjTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowNumberjTxtFldActionPerformed(evt);
            }
        });
        jPanel1.add(rowNumberjTxtFld);

        columnNumberjLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        columnNumberjLbl.setText("Columnas ");
        jPanel1.add(columnNumberjLbl);

        columnNumberjTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnNumberjTxtFldActionPerformed(evt);
            }
        });
        jPanel1.add(columnNumberjTxtFld);

        deletejBttn.setText("BORRAR");
        deletejBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editorContainerLayout = new javax.swing.GroupLayout(editorContainer);
        editorContainer.setLayout(editorContainerLayout);
        editorContainerLayout.setHorizontalGroup(
            editorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editorContainerLayout.createSequentialGroup()
                .addGroup(editorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editorContainerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(positionjLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletejBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editorContainerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(editorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputjScrllPn)
                            .addGroup(editorContainerLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(chargeFilejBttn, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        editorContainerLayout.setVerticalGroup(
            editorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editorContainerLayout.createSequentialGroup()
                .addGroup(editorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editorContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editorContainerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chargeFilejBttn)
                        .addGap(18, 18, 18)))
                .addComponent(inputjScrllPn, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editorContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editorContainerLayout.createSequentialGroup()
                        .addComponent(positionjLbl)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editorContainerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deletejBttn))))
        );

        getContentPane().add(editorContainer);

        containerCanvasjPnl.setPreferredSize(new java.awt.Dimension(480, 480));

        javax.swing.GroupLayout containerCanvasjPnlLayout = new javax.swing.GroupLayout(containerCanvasjPnl);
        containerCanvasjPnl.setLayout(containerCanvasjPnlLayout);
        containerCanvasjPnlLayout.setHorizontalGroup(
            containerCanvasjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        containerCanvasjPnlLayout.setVerticalGroup(
            containerCanvasjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        getContentPane().add(containerCanvasjPnl);

        OptionsjMn.setText("Opciones");

        reportsjMnItm.setText("Mostrar Reportes");
        reportsjMnItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsjMnItmActionPerformed(evt);
            }
        });
        OptionsjMn.add(reportsjMnItm);
        OptionsjMn.add(optionsjSprtr);

        exportImgjMnItm.setText("Exportar Lienzo");
        exportImgjMnItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportImgjMnItmActionPerformed(evt);
            }
        });
        OptionsjMn.add(exportImgjMnItm);

        jMnBr.add(OptionsjMn);

        setJMenuBar(jMnBr);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rowNumberjTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowNumberjTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowNumberjTxtFldActionPerformed

    private void columnNumberjTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnNumberjTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_columnNumberjTxtFldActionPerformed

    private void inputjTxtArCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inputjTxtArCaretUpdate
        // TODO add your handling code here:
        try {
            createCanvas();
            updateCaretPosition();
            String input = inputjTxtAr.getText();
            lexicalAnalyzer = new LexicalAnalyzer();
            lexicalAnalyzer.analyze(input, canvas, this);
            updateCanvas();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_inputjTxtArCaretUpdate

    private void chargeFilejBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeFilejBttnActionPerformed
        // TODO add your handling code here:
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(readFile(false))));
            createCanvas();
            inputjTxtAr.setText(fileContent);
        } catch (NullPointerException | IOException e) {
           cleanCanvas();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanCanvas();
        }
    }//GEN-LAST:event_chargeFilejBttnActionPerformed

    private void reportsjMnItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsjMnItmActionPerformed
        // TODO add your handling code here:
        updateTokensReports(canvas);
        ReportsJFrm reportsJFrm = new ReportsJFrm(tokensReports);
        reportsJFrm.setVisible(true);

    }//GEN-LAST:event_reportsjMnItmActionPerformed

    private void deletejBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejBttnActionPerformed
        // TODO add your handling code here:
        rowNumberjTxtFld.setText(null);
        columnNumberjTxtFld.setText(null);
        inputjTxtAr.setText(null);
        containerCanvasjPnl.removeAll();
        containerCanvasjPnl.repaint();
        containerCanvasjPnl.revalidate();
        this.repaint();
        this.revalidate();
    }//GEN-LAST:event_deletejBttnActionPerformed

    private void exportImgjMnItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportImgjMnItmActionPerformed
        // TODO add your handling code here:
        createImg();
    }//GEN-LAST:event_exportImgjMnItmActionPerformed

    private void createCanvas() {
        try {
            int row = Integer.parseInt(rowNumberjTxtFld.getText());
            int column = Integer.parseInt(columnNumberjTxtFld.getText());
            canvas = new Pixel[row][column];
            for (Pixel[] canva : canvas) {
                for (int j = 0; j < canva.length; j++) {
                    canva[j] = new Pixel();
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("El numero ingresado en la fila o columna es un valor invalido");
        }
    }

    private void createImg() {
        try {
            String path = readFile(true) + File.separatorChar + "Mi_Lienzo"+LocalDateTime.now()+".png";
            int width = canvas[0].length;  // Número de columnas
            int height = canvas.length;
            int buttonWidth = canvas[0][0].getWidth(); // Ancho de cada "botón" en la imagen
            int buttonHeight = canvas[0][0].getHeight(); // Altura de cada "botón" en la imagen// Número de filas

            BufferedImage image = new BufferedImage(width * buttonWidth, height * buttonHeight, BufferedImage.TYPE_INT_RGB);
            
            for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color color = canvas[row][col].getBackground(); // Obtener el color de fondo del botón
                for (int y = 0; y < buttonHeight; y++) {
                    for (int x = 0; x < buttonWidth; x++) {
                        image.setRGB(col * buttonWidth + x, row * buttonHeight + y, color.getRGB());
                    }
                }
            }
        }
            
            ImageIO.write(image, "png", new File(path));
            JOptionPane.showMessageDialog(this, "Imagen guardada en: "+ path, "Imagen guardada exitosamente",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"error al crear el archivo", "ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Exportar cancelado","", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void cleanCanvas(){
        inputjTxtAr.setText(null);
        containerCanvasjPnl.removeAll();
        containerCanvasjPnl.revalidate();
        containerCanvasjPnl.repaint();
    }

    private void updateCaretPosition() {
        try {
            int caretPos = inputjTxtAr.getCaretPosition(); // Obtiene la posición del cursor
            int line = inputjTxtAr.getLineOfOffset(caretPos); // Calcula la línea actual (fila)
            int column = caretPos - inputjTxtAr.getLineStartOffset(line); // Calcula la columna actual
            positionjLbl.setText("Fila: " + (line + 1) + ", Columna: " + (column + 1));
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(this, "error al actualizar la linea y columna ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCanvas() {
        containerCanvasjPnl.removeAll();
        containerCanvasjPnl.setLayout(new GridLayout(canvas.length, canvas[0].length));
        for (Pixel[] canva : canvas) {
            for (Pixel pixel : canva) {
                containerCanvasjPnl.add(pixel);
            }
        }
        containerCanvasjPnl.repaint();
        containerCanvasjPnl.revalidate();
        this.pack();
        this.repaint();
        this.revalidate();
    }

    public void updateTokensReports(Pixel[][] canvas) {

        tokensReports = new ArrayList<>();
        for (Pixel[] canva : canvas) {
            for (Pixel pixel : canva) {
                if (pixel.hasToken()) {
                    tokensReports.add(pixel.getToken());
                }
            }
        }
    }

    private String readFile(boolean directoriesOnly) {
        JFileChooser fileChooser = new JFileChooser();
        if (directoriesOnly) {
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int selection = fileChooser.showOpenDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            throw new NullPointerException();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu OptionsjMn;
    private javax.swing.JButton chargeFilejBttn;
    private javax.swing.JLabel columnNumberjLbl;
    private javax.swing.JTextField columnNumberjTxtFld;
    private javax.swing.JPanel containerCanvasjPnl;
    private javax.swing.JButton deletejBttn;
    private javax.swing.JPanel editorContainer;
    private javax.swing.JMenuItem exportImgjMnItm;
    private javax.swing.JScrollPane inputjScrllPn;
    private javax.swing.JTextArea inputjTxtAr;
    private javax.swing.JMenuBar jMnBr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator optionsjSprtr;
    private javax.swing.JLabel positionjLbl;
    private javax.swing.JMenuItem reportsjMnItm;
    private javax.swing.JLabel rowNumberjLbl;
    private javax.swing.JTextField rowNumberjTxtFld;
    // End of variables declaration//GEN-END:variables

}
