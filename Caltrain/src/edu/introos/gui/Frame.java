/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.gui;

import edu.introos.spritesheet.Animator;
import edu.introos.spritesheet.BufferedImageLoader;
import edu.introos.spritesheet.SpriteSheet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Allendale
 */
public class Frame extends JFrame {
    
    ArrayList<BufferedImage> blueTrainSprites;
    BufferedImage sprite;
    Animator train;
    int state = 0, x = 0, y = 0;
    boolean mid_state = false;
    boolean positive = true;
    
    final int max_x = 1000;
    final int max_y = 630;
    
    public Frame(){
        this.setTitle("Caltrain Automation: Semaphores");
        this.setSize(1200,800);
        this.setMinimumSize(new Dimension(800,600));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        
        //this.add(new MainPanel());
    }
    
    public Frame getFrame(){
       return this;
    }
    
    public void init() {
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage spriteSheet = null;
        try {
            spriteSheet = loader.loadImage("train-sprite-sheet.png"); // might have a bug here!
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpriteSheet ss = new SpriteSheet(spriteSheet);
        
        blueTrainSprites = new ArrayList<BufferedImage>();
        
        blueTrainSprites.add(ss.grabSprite(158, 32, 125, 40)); // x-y-width-height - horizontal
        blueTrainSprites.add(ss.grabSprite(47, 89, 100, 72)); // to-the southwest
        blueTrainSprites.add(ss.grabSprite(234, 81, 29, 88)); // vertical
        blueTrainSprites.add(ss.grabSprite(47, 14, 101, 75)); // to the northeast
        // add other sprites here to serve as frame of the sprite itself
        
        train = new Animator(blueTrainSprites);
        train.setSpeed(100);
        train.play();
    }
    
    Image dbImage;
    Graphics dbg;
    
    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, null); // x-y-width-height 
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        if(train != null)
            train.update(System.currentTimeMillis());
        if (positive) {
            if(x < max_x) {
                x++;
            }
            else if (!mid_state) {
                mid_state = true;
                state++;
                g.drawImage(blueTrainSprites.get(state), 9 + x, 32 + y, null);
                repaint();
                state++;
            }
            else if (y < max_y) {
                y++;
            }
            else {
                mid_state = false;
                positive = false;
                state++;
                g.drawImage(blueTrainSprites.get(state), 9 + x, 32 + y, null);
                repaint();
                state++;
            }
        }
        else {
            if (x > 0) {
                x--;
            }
            else if(!mid_state) {
                mid_state = true;
                state++;
                g.drawImage(blueTrainSprites.get(state), max_x - (9 + x), max_y - (32 + y), null);
                repaint();
                state++;
            }
            else if (y > 0) {
                y--;
            }
            else {
                mid_state = false;
                positive = true;
                state++;
                g.drawImage(blueTrainSprites.get(state), 9 + x, 32 + y, null);
                repaint();
                state++;
            }
        }
            

        state = state % 4;
        
        g.drawImage(blueTrainSprites.get(state), 9 + x, 32 + y, null); // programmable
        repaint();
    }
}
