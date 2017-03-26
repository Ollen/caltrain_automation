/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Allendale
 */
public class Frame extends JFrame {
    public Frame(){
        this.setTitle("Caltrain Automation: Semaphores");
        this.setSize(1200,800);
        this.setMinimumSize(new Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public Frame getFrame(){
       return this;
    }
    
}
