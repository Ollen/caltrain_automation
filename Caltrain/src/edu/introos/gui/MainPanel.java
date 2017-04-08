/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Allendale
 */
public class MainPanel extends JPanel implements ActionListener {

    //Fonts
    private Font headerFont = new Font("Georgia", Font.PLAIN, 24);
    //Components
    private JLabel label_caltrain_header;
    
    public MainPanel(){
        //Set BG to White
        this.setBackground(Color.white);
        //Build the Components
        buildComponents();
        //Assemble the Components
        assembleComponents();
    }
    
    public void buildComponents(){
        label_caltrain_header = new JLabel("CalTrain Automation: Semaphores");
        label_caltrain_header.setFont(headerFont);
    }
    
    public void assembleComponents(){
        this.add(label_caltrain_header);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
