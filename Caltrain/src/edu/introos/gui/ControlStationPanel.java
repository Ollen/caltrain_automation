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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Allendale
 */
public class ControlStationPanel extends JPanel implements ActionListener {
    static JPanel  
            TaftPanel,
            MagallanesPanel,
            AyalaPanel,
            BuendiaPanel,
            GuadalupePanel,
            BoniPanel,
            ShawPanel,
            OrtigasPanel;
    
    static JLabel  label_taft_train,
            label_magallanes_train,
            label_ayala_train,
            label_buendia_train,
            label_guadalupe_train,
            label_boni_train,
            label_shaw_train,
            label_ortigas_train;
    
    //Fonts
    Font stationFont = new Font("Georgia", Font.PLAIN, 20);
    
    
    public ControlStationPanel(){
        this.setLayout(new MigLayout("", "[150,fill]", "[150,fill]"));
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Stations",
                TitledBorder.CENTER, TitledBorder.TOP));
        //Set the Components
        buildComponents();
        //Construct the Panel
        assembleComponents();
    }
    
    public void buildComponents(){
        
        label_taft_train = new JLabel("");
        label_taft_train.setFont(stationFont);
        
        label_magallanes_train = new JLabel("");
        label_magallanes_train.setFont(stationFont);
        
        label_ayala_train = new JLabel("");
        label_ayala_train.setFont(stationFont);
        
        label_buendia_train = new JLabel("");
        label_buendia_train.setFont(stationFont);
        
        label_guadalupe_train = new JLabel("");
        label_guadalupe_train.setFont(stationFont);
        
        label_boni_train = new JLabel("");
        label_boni_train.setFont(stationFont);
        
        label_shaw_train = new JLabel("");
        label_shaw_train.setFont(stationFont);
        
        label_ortigas_train = new JLabel("");
        label_ortigas_train.setFont(stationFont);
        
        TaftPanel = new JPanel(new MigLayout());
        TaftPanel.setBackground(Color.cyan);
        TaftPanel.add(new JLabel("Taft"), "pushx, center, wrap 10");
        TaftPanel.add(label_taft_train, "pushx, center");
        
        MagallanesPanel = new JPanel(new MigLayout());
        MagallanesPanel.setBackground(Color.cyan);
        MagallanesPanel.add(new JLabel("Magallanes"), "pushx, center, wrap 10");
        MagallanesPanel.add(label_magallanes_train, "pushx, center");
        
        AyalaPanel = new JPanel(new MigLayout());
        AyalaPanel.setBackground(Color.cyan);
        AyalaPanel.add(new JLabel("Ayala"), "pushx, center, wrap 10");
        AyalaPanel.add(label_ayala_train, "pushx, center");
        
        BuendiaPanel = new JPanel(new MigLayout());
        BuendiaPanel.setBackground(Color.cyan);
        BuendiaPanel.add(new JLabel("Buendia"), "pushx, center, wrap 10");
        BuendiaPanel.add(label_buendia_train, "pushx, center");
        
        GuadalupePanel = new JPanel(new MigLayout());
        GuadalupePanel.setBackground(Color.cyan);
        GuadalupePanel.add(new JLabel("Guadalupe"), "pushx, center, wrap 10");
        GuadalupePanel.add(label_guadalupe_train, "pushx, center");
        
        BoniPanel = new JPanel(new MigLayout());
        BoniPanel.setBackground(Color.cyan);
        BoniPanel.add(new JLabel("Boni"), "pushx, center, wrap 10");
        BoniPanel.add(label_boni_train, "pushx, center");
        
        ShawPanel = new JPanel(new MigLayout());
        ShawPanel.setBackground(Color.cyan);
        ShawPanel.add(new JLabel("Shaw"), "pushx, center, wrap 10");
        ShawPanel.add(label_shaw_train, "pushx, center");
        
        OrtigasPanel = new JPanel(new MigLayout());
        OrtigasPanel.setBackground(Color.cyan);
        OrtigasPanel.add(new JLabel("Ortigas"), "pushx, center, wrap 10");
        OrtigasPanel.add(label_ortigas_train, "pushx, center");
        
        
    }
    
    public void assembleComponents(){
        this.add(TaftPanel, "cell 0 0");
        this.add(MagallanesPanel, "cell 0 1");
        this.add(AyalaPanel, "cell 0 2");
        this.add(BuendiaPanel, "cell 0 3");
        this.add(GuadalupePanel, "cell 0 4");
        this.add(BoniPanel, "cell 0 5");
        this.add(ShawPanel, "cell 0 6");
        this.add(OrtigasPanel, "cell 0 7");
    }
    
    public static void setOccupied(String stationName, String trainName){
        switch(stationName){
            case "Taft":            TaftPanel.setBackground(Color.decode("#ffc107"));
                                    label_taft_train.setText(trainName);
                                    break;
            case "Magallanes":      MagallanesPanel.setBackground(Color.decode("#ffc107"));
                                    label_magallanes_train.setText(trainName);
                                    break;
            case "Ayala":           AyalaPanel.setBackground(Color.decode("#ffc107"));
                                    label_ayala_train.setText(trainName);
                                    break;
            case "Buendia":         BuendiaPanel.setBackground(Color.decode("#ffc107"));
                                    label_buendia_train.setText(trainName);
                                    break;               
            case "Guadalupe":       GuadalupePanel.setBackground(Color.decode("#ffc107"));
                                    label_guadalupe_train.setText(trainName);
                                    break;
            case "Boni":            BoniPanel.setBackground(Color.decode("#ffc107"));
                                    label_boni_train.setText(trainName);
                                    break;                
            case "Shaw":            ShawPanel.setBackground(Color.decode("#ffc107"));
                                    label_shaw_train.setText(trainName);
                                    break;
            case "Ortigas":         OrtigasPanel.setBackground(Color.decode("#ffc107"));
                                    label_ortigas_train.setText(trainName);
                                    break;           
        }
    }
    
    public static void setFree(String stationName){
        switch(stationName){
            case "Taft":            TaftPanel.setBackground(Color.cyan);
                                    label_taft_train.setText("");
                                    break;
            case "Magallanes":      MagallanesPanel.setBackground(Color.cyan);
                                    label_magallanes_train.setText("");
                                    break;
            case "Ayala":           AyalaPanel.setBackground(Color.cyan);
                                    label_ayala_train.setText("");
                                    break;
            case "Buendia":         BuendiaPanel.setBackground(Color.cyan);
                                    label_buendia_train.setText("");
                                    break;               
            case "Guadalupe":       GuadalupePanel.setBackground(Color.cyan);
                                    label_guadalupe_train.setText("");
                                    break;
            case "Boni":            BoniPanel.setBackground(Color.cyan);
                                    label_boni_train.setText("");
                                    break;                
            case "Shaw":            ShawPanel.setBackground(Color.cyan);
                                    label_shaw_train.setText("");
                                    break;
            case "Ortigas":         OrtigasPanel.setBackground(Color.cyan);
                                    label_ortigas_train.setText("");
                                    break;           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
