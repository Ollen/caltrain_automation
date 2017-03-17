/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.main;

import edu.introos.dto.Station;

/**
 *
 * @author Allendale
 */
public class Caltrain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread[] stationThreads = new Thread[8];
       String[] stationNames = {"Taft", "Magallanes", "Ayala", "Buendia", "Guadalupe", "Boni", "Shaw", "Ortigas"}; 
       for(int i = 0; i < 8; i++) {

           stationThreads[i] = new Thread(new Station());
           stationThreads[i].
           stationThreads[i].start();
       }

    }
    
}
