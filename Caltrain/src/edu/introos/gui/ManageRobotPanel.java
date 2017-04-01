/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import edu.introos.main.Caltrain_X;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Allendale
 */
public class ManageRobotPanel extends JPanel implements ActionListener {
    
    JComboBox   combo_station_source,
                combo_station_dest;
    
    JTextField  text_passenger_num;
    
    JLabel      label_station_source,
                label_station_dest,
                label_passenger_num;
    
    JButton     button_add_passengers;
    
    Font labelFont = new Font("Trebuchet MS", Font.PLAIN + Font.BOLD, 14);
    
    
    public ManageRobotPanel(){
        this.setLayout(new MigLayout("", "[]20[]", ""));
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Add Passengers",
                TitledBorder.CENTER, TitledBorder.TOP));
        
        buildComponents();
        assembleComponents();
    }
    
    public void buildComponents(){
        combo_station_source = new JComboBox(Caltrain_X.stationNames);
        combo_station_dest = new JComboBox(Caltrain_X.stationNames);
        
        text_passenger_num = new JTextField(5);
        
        label_station_source = new JLabel("Passenger Source");
        label_station_dest = new JLabel("Passenger Destination");
        label_passenger_num = new JLabel("Passenger Spawn Number");
        label_station_source.setFont(labelFont);
        label_station_dest.setFont(labelFont);
        label_passenger_num.setFont(labelFont);
        
        button_add_passengers = new JButton("Add Passengers");
        button_add_passengers.addActionListener(this);
    }
    
    public void assembleComponents(){
        this.add(label_station_source, "growx, pushx");
        this.add(label_station_dest, "growx, pushx, wrap, ");
        this.add(combo_station_source, "growx, pushx, sg combo, w 200!");
        this.add(combo_station_dest, "growx, pushx, sg combo, wrap 20");
        
        this.add(label_passenger_num, "span, center, wrap");
        this.add(text_passenger_num, "span, center, wrap 10");
        
        this.add(button_add_passengers, "pushx, growx, span");
       
    }
    
    public boolean checkPassengerInput(){
        int source = combo_station_source.getSelectedIndex();
        int destination = combo_station_dest.getSelectedIndex();
        int passenger_num = 0;
        
        try{
            passenger_num = Integer.parseInt(text_passenger_num.getText());
        } catch(Exception ex){
            JOptionPane.showMessageDialog(ManageRobotPanel.this, "Invalid Passenger Num", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_add_passengers){
            if(checkPassengerInput()){
                String string_source = (String)combo_station_source.getSelectedItem();
                String string_destination = (String)combo_station_dest.getSelectedItem();
                String string_passenger_num = text_passenger_num.getText();
                
                int source = combo_station_source.getSelectedIndex();
                int destination = combo_station_dest.getSelectedIndex();
                int passenger_num = Integer.parseInt(text_passenger_num.getText());
                
                if(source < destination){
                    destination = (destination - source) - 1;
                } else if(source > destination){
                    destination = (7 - source) + destination;
                } else if(source == destination){
                    destination = 7;
                }
                
                Caltrain_X.stations[source].GeneratePassengers(passenger_num, destination);
                
                JOptionPane.showMessageDialog(ManageRobotPanel.this, "Successfully added " + string_passenger_num
                        + " Passenger in " + string_source + " going to " + string_destination , "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    
}
