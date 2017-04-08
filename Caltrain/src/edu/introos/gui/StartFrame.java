/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Allendale
 */
public class StartFrame extends JFrame implements ActionListener {
    
    public JRadioButton semaphore, locks;
    public JButton button;
    
    public StartFrame(){
        this.setTitle("Choose an Implementation");
        this.setSize(200,200);
        this.setMinimumSize(new Dimension(200, 200));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new MigLayout(""));
        
        semaphore = new JRadioButton("Semaphore");
        locks = new JRadioButton("Locks");
        button = new JButton("Start Simulation");
        ButtonGroup group = new ButtonGroup();
        group.add(semaphore);
        group.add(locks);
        
        this.add(semaphore, "split 2, gapbottom 40");
        this.add(locks, "wrap");
        this.add(button, "push, grow");
        
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        Caltrain_GUI.textFrame = new TextFrame();
        Caltrain_GUI.trainFrame = new TrainFrame();
        Caltrain_GUI.stationFrame = new StationFrame();
    }
    
}
