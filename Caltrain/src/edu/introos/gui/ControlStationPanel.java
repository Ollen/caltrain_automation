/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import java.awt.Color;
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
    
    
    public ControlStationPanel(){
        this.setLayout(new MigLayout("", "[100,fill]", "[100,fill]"));
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Stations",
                TitledBorder.CENTER, TitledBorder.TOP));
        //Set the Components
        buildComponents();
        //Construct the Panel
        assembleComponents();
    }
    
    public void buildComponents(){
        
        TaftPanel = new JPanel(new MigLayout());
        TaftPanel.setBackground(Color.cyan);
        TaftPanel.add(new JLabel("Taft"), "pushx, center");
        
        MagallanesPanel = new JPanel(new MigLayout());
        MagallanesPanel.setBackground(Color.cyan);
        MagallanesPanel.add(new JLabel("Magallanes"), "pushx, center");
        
        AyalaPanel = new JPanel(new MigLayout());
        AyalaPanel.setBackground(Color.cyan);
        AyalaPanel.add(new JLabel("Ayala"), "pushx, center");
        
        BuendiaPanel = new JPanel(new MigLayout());
        BuendiaPanel.setBackground(Color.cyan);
        BuendiaPanel.add(new JLabel("Buendia"), "pushx, center");
        
        GuadalupePanel = new JPanel(new MigLayout());
        GuadalupePanel.setBackground(Color.cyan);
        GuadalupePanel.add(new JLabel("Guadalupe"), "pushx, center");
        
        BoniPanel = new JPanel(new MigLayout());
        BoniPanel.setBackground(Color.cyan);
        BoniPanel.add(new JLabel("Boni"), "pushx, center");
        
        ShawPanel = new JPanel(new MigLayout());
        ShawPanel.setBackground(Color.cyan);
        ShawPanel.add(new JLabel("Shaw"), "pushx, center");
        
        OrtigasPanel = new JPanel(new MigLayout());
        OrtigasPanel.setBackground(Color.cyan);
        OrtigasPanel.add(new JLabel("Ortigas"), "pushx, center");
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
    
    public static void setOccupied(String stationName){
        switch(stationName){
            case "Taft":            TaftPanel.setBackground(Color.decode("#ffc107"));
                                    break;
            case "Magallanes":      MagallanesPanel.setBackground(Color.decode("#ffc107"));
                                    break;
            case "Ayala":           AyalaPanel.setBackground(Color.decode("#ffc107"));
                                    break;
            case "Buendia":         BuendiaPanel.setBackground(Color.decode("#ffc107"));
                                    break;               
            case "Guadalupe":       GuadalupePanel.setBackground(Color.decode("#ffc107"));
                                    break;
            case "Boni":            BoniPanel.setBackground(Color.decode("#ffc107"));
                                    break;                
            case "Shaw":            ShawPanel.setBackground(Color.decode("#ffc107"));
                                    break;
            case "Ortigas":         OrtigasPanel.setBackground(Color.decode("#ffc107"));
                                    break;           
        }
    }
    
    public static void setFree(String stationName){
        switch(stationName){
            case "Taft":            TaftPanel.setBackground(Color.cyan);
                                    break;
            case "Magallanes":      MagallanesPanel.setBackground(Color.cyan);
                                    break;
            case "Ayala":           AyalaPanel.setBackground(Color.cyan);
                                    break;
            case "Buendia":         BuendiaPanel.setBackground(Color.cyan);
                                    break;               
            case "Guadalupe":       GuadalupePanel.setBackground(Color.cyan);
                                    break;
            case "Boni":            BoniPanel.setBackground(Color.cyan);
                                    break;                
            case "Shaw":            ShawPanel.setBackground(Color.cyan);
                                    break;
            case "Ortigas":         OrtigasPanel.setBackground(Color.cyan);
                                    break;           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
