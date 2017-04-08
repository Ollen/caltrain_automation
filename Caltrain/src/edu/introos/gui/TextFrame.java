/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Allen
 */
public class TextFrame extends JFrame {
    public static JTextArea textarea;
    JScrollPane scrollPane;
    
    public TextFrame(){
        this.setTitle("CalTrain Text Output");
        this.setSize(600,400);
        this.setMinimumSize(new Dimension(600, 400));
        this.setLocation(10,10);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new MigLayout());
        
        buildComponents();
        assembleComponents();
    }
    
    public void buildComponents(){
        textarea = new JTextArea();
        //textarea.setCaretPosition(textarea.getDocument().getLength());
        scrollPane = new JScrollPane(textarea);    
    }
    
    public void assembleComponents(){
        this.add(scrollPane, "grow, push");
    }
    
    
    
    
    
}
