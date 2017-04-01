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
public class RobotWaitingPanel extends JPanel implements ActionListener {
    public static JPanel  
            TaftPanel,
            MagallanesPanel,
            AyalaPanel,
            BuendiaPanel,
            GuadalupePanel,
            BoniPanel,
            ShawPanel,
            OrtigasPanel;
    
    public static JLabel  label_taft_waiting,
            label_magallanes_waiting,
            label_ayala_waiting,
            label_buendia_waiting,
            label_guadalupe_waiting,
            label_boni_waiting,
            label_shaw_waiting,
            label_ortigas_waiting;
    
    
    //Fonts
    Font stationFont = new Font("Georgia", Font.PLAIN, 20);
    
    public RobotWaitingPanel(){
        this.setLayout(new MigLayout("", "[150,fill, grow]", "[150,fill]"));
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED), "Waiting",
                TitledBorder.CENTER, TitledBorder.TOP));
        
        buildComponents();
        assembleComponents();
        
        
    }
    
    public void buildComponents(){
        label_taft_waiting = new JLabel("0");
        label_taft_waiting.setFont(stationFont);
        
        label_magallanes_waiting = new JLabel("0");
        label_magallanes_waiting.setFont(stationFont);
        
        label_ayala_waiting = new JLabel("0");
        label_ayala_waiting.setFont(stationFont);
        
        label_buendia_waiting = new JLabel("0");
        label_buendia_waiting.setFont(stationFont);
        
        label_guadalupe_waiting = new JLabel("0");
        label_guadalupe_waiting.setFont(stationFont);
        
        label_boni_waiting = new JLabel("0");
        label_boni_waiting.setFont(stationFont);
        
        label_shaw_waiting = new JLabel("0");
        label_shaw_waiting.setFont(stationFont);
        
        label_ortigas_waiting = new JLabel("0");
        label_ortigas_waiting.setFont(stationFont);
        
        TaftPanel = new JPanel(new MigLayout());
        TaftPanel.setBackground(Color.white);
        TaftPanel.add(label_taft_waiting, "pushx, center, wrap 10, gaptop 10");
        TaftPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        MagallanesPanel = new JPanel(new MigLayout());
        MagallanesPanel.setBackground(Color.white);
        MagallanesPanel.add(label_magallanes_waiting, "pushx, center, wrap 10, gaptop 10");
        MagallanesPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        AyalaPanel = new JPanel(new MigLayout());
        AyalaPanel.setBackground(Color.white);
        AyalaPanel.add(label_ayala_waiting, "pushx, center, wrap 10, gaptop 10");
        AyalaPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        
        BuendiaPanel = new JPanel(new MigLayout());
        BuendiaPanel.setBackground(Color.white);
        BuendiaPanel.add(label_buendia_waiting, "pushx, center, wrap 10, gaptop 10");
        BuendiaPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        GuadalupePanel = new JPanel(new MigLayout());
        GuadalupePanel.setBackground(Color.white);
        GuadalupePanel.add(label_guadalupe_waiting, "pushx, center, wrap 10, gaptop 10");
        GuadalupePanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        BoniPanel = new JPanel(new MigLayout());
        BoniPanel.setBackground(Color.white);
        BoniPanel.add(label_boni_waiting, "pushx, center, wrap 10, gaptop 10");
        BoniPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        ShawPanel = new JPanel(new MigLayout());
        ShawPanel.setBackground(Color.white);
        ShawPanel.add(label_shaw_waiting, "pushx, center, wrap 10, gaptop 10");
        ShawPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
        
        OrtigasPanel = new JPanel(new MigLayout());
        OrtigasPanel.setBackground(Color.white);
        OrtigasPanel.add(label_ortigas_waiting, "pushx, center, wrap 10, gaptop 10");
        OrtigasPanel.add(new JLabel("Waiting Passengers"), "pushx, center");
    }
    
    public void assembleComponents(){
        this.add(TaftPanel, "cell 0 0");
        this.add(MagallanesPanel, "cell 1 0");
        this.add(AyalaPanel, "cell 2 0");
        this.add(BuendiaPanel, "cell 3 0");
        this.add(GuadalupePanel, "cell 4 0");
        this.add(BoniPanel, "cell 5 0");
        this.add(ShawPanel, "cell 6 0");
        this.add(OrtigasPanel, "cell 7 0");
    }
    
        public static void setWaiting(String stationName, int waiting){
        switch(stationName){
            case "Taft":            label_taft_waiting.setText(waiting + "");
                                    break;
            case "Magallanes":      label_magallanes_waiting.setText(waiting + "");
                                    break;
            case "Ayala":           label_ayala_waiting.setText(waiting + "");
                                    break;
            case "Buendia":         label_buendia_waiting.setText(waiting + "");
                                    break;               
            case "Guadalupe":       label_guadalupe_waiting.setText(waiting + "");
                                    break;
            case "Boni":            label_boni_waiting.setText(waiting + "");
                                    break;                
            case "Shaw":           label_shaw_waiting.setText(waiting + "");
                                    break;
            case "Ortigas":         label_ortigas_waiting.setText(waiting + "");
                                    break;           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
