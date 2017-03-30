/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Allendale
 */
public class FrameControl extends JFrame {
    JScrollPane jsp = new JScrollPane(new ControlPanel());
    public FrameControl(){
        this.setTitle("CalTrain Control Panel");
        this.setSize(1000,1000);
        this.setLocation(10, 10);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(jsp);
    }
}
