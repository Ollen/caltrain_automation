/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import edu.introos.main.Caltrain_X;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
   
    Caltrain_X Caltrain;
    
    //Initialize Components
    JPanel  addTrainPanel,
            headerPanel,
            sidePanel;
    
    ControlStationPanel stationPanel = new ControlStationPanel();
    ControlWaitingPanel waitingPanel = new ControlWaitingPanel();
    ControlTrainPanel trainPanel = new ControlTrainPanel();
    
    JLabel  label_header,
            label_train_num,
            label_train_count,
            label_train_name,
            label_train_seats;
    
    JTextField  textfield_train_name,
                textfield_train_seats;
    JSeparator separator = new JSeparator();
    JButton button_add_train,
            button_exit_simulation;
    //End of Initialization
    
    //Fonts
    Font headerFont = new Font("Georgia", Font.PLAIN, 20);
    Font trainNumFont = new Font("Georgia", Font.PLAIN, 18);
    Font labelFont = new Font("Tahoma", Font.PLAIN, 14);
    Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);
    Font buttonFont = new Font("Segoe UI", Font.BOLD, 16);
    Font borderTitleFont = new Font("Segoe UI", Font.ITALIC + Font.BOLD, 16);
    //End of Fonts
    
    public ControlPanel(){
        Caltrain = new Caltrain_X();
        //Set the Layout
        this.setLayout(new MigLayout("inset 20"));
        //Build the Components
        buildComponents();
        //Assemble the Components
        assembleComponents();
    }
    
    public void buildComponents(){
        headerPanel = new JPanel();
        headerPanel.setLayout(new MigLayout(""));
        
        addTrainPanel = new JPanel();
        addTrainPanel.setLayout(new MigLayout(""));
        addTrainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Add a Train",
                TitledBorder.LEFT, TitledBorder.TOP, borderTitleFont, Color.decode("#006158")));
        
        sidePanel = new JPanel(new MigLayout());
        
        label_header = new JLabel("Train Manager");
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
        button_add_train.addActionListener(this);
        
        button_exit_simulation = new JButton("Exit Simulation");
        button_exit_simulation.setFocusPainted(false);
        button_exit_simulation.setFont(buttonFont);
        button_exit_simulation.addActionListener(this);
        
    }
    
    public void assembleComponents(){
        headerPanel.add(label_header, "pushx, center, gaptop 20, wrap");
        headerPanel.add(separator, "growx, wrap 20, wrap");
        sidePanel.add(headerPanel, "pushx, growx, wrap");
        
        
        //Add Train Num
        //this.add(label_train_num, "pushx, center, wrap");
        //this.add(label_train_count, "pushx, center, wrap 20");
        
        //Add Train information input
        addTrainPanel.add(label_train_name, "");
        addTrainPanel.add(label_train_seats, "wrap");
        addTrainPanel.add(textfield_train_name, "growx, pushx");
        addTrainPanel.add(textfield_train_seats, "growx, pushx,wrap 10");
        addTrainPanel.add(button_add_train, "span, center");
        
        //this.add(addTrainPanel, "pushx, growx, wrap 10");
        
        sidePanel.add(label_train_num, "pushx, center, wrap");
        sidePanel.add(label_train_count, "pushx, center, wrap 20");
        sidePanel.add(addTrainPanel, "pushx, growx");
        this.add(sidePanel, "dock west");
        
        this.add(trainPanel, "center, grow, push");
        //this.add(button_exit_simulation, "dock south, w 650!, center, gaptop 10, gapbottom 10");
        
        
    }
    
    public boolean checkAddTrain(String name, String seats){
        String trainName = name.trim();
        int trainSeats = 0;
        
        if(trainName.isEmpty() || trainName == null){
            JOptionPane.showMessageDialog(ControlPanel.this, "Invalid Train Name", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try{
            trainSeats = Integer.parseInt(seats);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(ControlPanel.this, "Invalid Train Number Seat", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(trainSeats <= 0){
            JOptionPane.showMessageDialog(ControlPanel.this, "Please Enter a Positive Seat Number", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_add_train){
            String name = textfield_train_name.getText();
            String seats = textfield_train_seats.getText();
            
            if(checkAddTrain(name, seats)){
                if(Caltrain.numOfTrains == 16){
                    JOptionPane.showMessageDialog(ControlPanel.this, "Maximum Train Limit", "Error",
                    JOptionPane.ERROR_MESSAGE);
                } else{
                    int seatInt = Integer.parseInt(textfield_train_seats.getText());
                    
                    Caltrain.dispatchTrain(name.trim(), seatInt, Caltrain.numOfTrains);
                    // Paint Train List
                    
                    Caltrain.numOfTrains ++;
                    JOptionPane.showMessageDialog(ControlPanel.this, "Created a New Train", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    textfield_train_name.setText("");
                    textfield_train_seats.setText("");
                    label_train_count.setText(Caltrain.numOfTrains + " out of 16");
                        
                }
            }
            
        }
        
        if(e.getSource() == button_exit_simulation){
            System.exit(0);
        }
    }
    
}
