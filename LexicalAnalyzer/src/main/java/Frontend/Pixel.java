/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.Token;
import guru.nidi.graphviz.attribute.Attributes;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import static guru.nidi.graphviz.model.Factory.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import guru.nidi.graphviz.model.Node;

import java.awt.*;
import java.time.LocalDateTime;

/**
 *
 * @author brigidoalvarado
 */
public class Pixel extends javax.swing.JButton {

    private Token token;
    private Graph graph;
    private boolean hasToken = false;

    private void showAutomatonActionPerformed(java.awt.event.ActionEvent evt) {
        String conten
                = "Linea : " + String.valueOf(token.getEditorRow())
                + " Columna: " + String.valueOf(token.getEditorColumn())
                + " --> Cuadro[" + String.valueOf(token.getPixelRow()) + "," + String.valueOf(token.getPixelColumn()) + "]";
        createGraph();
        File file = saveImg();
        ImageIcon icon = new ImageIcon(file.getPath());
        JOptionPane.showMessageDialog(
                token.getApp(), conten, token.getKind(), JOptionPane.INFORMATION_MESSAGE, icon);
        file.delete();

    }

    private void createGraph() {
        char[] lexeme = token.getLexeme().toCharArray();
        // en caso de que el lexema sea de solo una letra
        if (lexeme.length == 1) {
            Node node = node(token.getLexeme());
            graph = graph("lexeme_graph").directed().with(node);
        } else {
            graph = graph("lexeme_graph").directed();
        }

        for (int i = 0; i < (lexeme.length - 1); i++) {
            graph = graph.with(node(String.valueOf(lexeme[i])).link(node(String.valueOf(lexeme[i + 1]))));

        }
    }

    private File saveImg() {
        File file = new File("lexeme_graph" + LocalDateTime.now() + ".png");
        try {
            Graphviz.fromGraph(graph).width(75).render(Format.PNG).toFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void setToken(Token token, int row, int column) {
        hasToken = true;
        this.token = token;
        this.token.setPixelRow(row);
        this.token.setPixelColumn(column);
        this.setBackground(Color.decode(token.getColor()));
        this.addActionListener(evt -> this.showAutomatonActionPerformed(evt));
    }

    public void setToken(Token token) {
        hasToken = true;
        this.token = token;
        this.setBackground(Color.decode(token.getColor()));
    }

    public boolean hasToken() {
        return hasToken;
    }

    public Token getToken() {
        return token;
    }
}
