/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Allendale
 */
public class StationFrame extends JFrame{
    public static JPanel stationPanel = new StationVisualPanel();
    public static JPanel robotPanel = new RobotWaitingPanel();
    
    
    public StationFrame(){
        this.setTitle("CalTrain Station Manager");
        this.setSize(1200,450);
        this.setMinimumSize(new Dimension(1200, 400));
        this.setLocation(10,10);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new MigLayout());
        
        this.add(stationPanel, "pushx, growx, wrap");
        this.add(robotPanel, "pushx, growx, wrap");
        this.add(new ManageRobotPanel(), "pushx, center");
    }
    
}
