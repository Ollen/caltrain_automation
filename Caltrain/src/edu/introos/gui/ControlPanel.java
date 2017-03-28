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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Allendale
 */
public class ControlPanel extends JPanel implements ActionListener {
    
    //Initialize Components
    
    JPanel  addTrainPanel;
    
    JLabel  label_header,
            label_train_num,
            label_train_count,
            label_train_name,
            label_train_seats;
    
    JTextField  textfield_train_name,
                textfield_train_seats;
    JSeparator separator = new JSeparator();
    JButton button_add_train;
    //End of Initialization
    
    //Fonts
    Font headerFont = new Font("Georgia", Font.PLAIN, 20);
    Font trainNumFont = new Font("Georgia", Font.PLAIN, 18);
    Font labelFont = new Font("Tahoma", Font.PLAIN, 14);
    Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);
    Font buttonFont = new Font("Segoe UI", Font.BOLD, 16);
    Font borderTitleFont = new Font("Segoe UI", Font.ITALIC + Font.BOLD, 16);    
    public ControlPanel(){
        //Set the Layout
        this.setLayout(new MigLayout(""));
        //Build the Components
        buildComponents();
        //Assemble the Components
        assembleComponents();
    }
    
    public void buildComponents(){
        addTrainPanel = new JPanel();
        addTrainPanel.setLayout(new MigLayout("debug"));
        addTrainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Add a Train",
                TitledBorder.LEFT, TitledBorder.TOP, borderTitleFont, Color.decode("#006158")));
        
        label_header = new JLabel("Control Panel");
        label_header.setFont(headerFont);
        
        label_train_num = new JLabel("Active Trains");
        label_train_num.setFont(trainNumFont);
        
        label_train_count = new JLabel("0 out of 16");
        label_train_count.setFont(trainNumFont);
        label_train_count.setForeground(Color.decode("#e91e63"));
        
        label_train_name = new JLabel("Train Name: ");
        label_train_name.setFont(fieldFont);
        label_train_seats = new JLabel("Num of Seats");
        label_train_seats.setFont(fieldFont);
        
        textfield_train_name = new JTextField(10);
        textfield_train_name.setFont(fieldFont);
        
        textfield_train_seats = new JTextField(10);
        textfield_train_seats.setFont(fieldFont);
        
        button_add_train = new JButton("Add Train!");
        button_add_train.setFocusPainted(false);
        button_add_train.setFont(buttonFont);
        button_add_train.setForeground(Color.white);
        button_add_train.setBackground(Color.decode("#04bbaa"));
        
    }
    
    public void assembleComponents(){
        this.add(label_header, "pushx, center, gaptop 20, wrap");
        this.add(separator, "growx, wrap 20");
        
        //Add Train Num
        this.add(label_train_num, "pushx, center, wrap");
        this.add(label_train_count, "pushx, center, wrap 20");
        
        //Add Train information input
        addTrainPanel.add(label_train_name, "");
        addTrainPanel.add(label_train_seats, "wrap");
        addTrainPanel.add(textfield_train_name, "growx, pushx");
        addTrainPanel.add(textfield_train_seats, "growx, pushx,wrap 10");
        addTrainPanel.add(button_add_train, "span, center");
        
        this.add(addTrainPanel, "pushx, growx");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
