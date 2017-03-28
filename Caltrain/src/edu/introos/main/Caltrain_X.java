/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.main;

import edu.introos.dto.Station;
import edu.introos.dto.Train;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Allendale
 */
public class Caltrain_X {
    static Thread[] trainThreads = new Thread[16];
    static Station[] stations = new Station[8];
    public static int numOfTrains = 0;
    static Semaphore availableSeats;
    
    static String[] stationNames = {"Taft", "Magallanes", "Ayala", "Buendia", "Guadalupe", "Boni", "Shaw", "Ortigas"}; 
    
    public Caltrain_X(){
        //Initialize the Stations
        for(int i = 0; i < 8; i++) {
           Station station = new Station(stationNames[i]);
           stations[i] = station;
       }
    }
    
    public static void dispatchTrain(String name, int seats){
        availableSeats = new Semaphore(seats, true);
        
        //Create The Train
        Train newTrain = new Train(availableSeats, seats, name, stations);
        trainThreads[numOfTrains] = new Thread(newTrain);
        trainThreads[numOfTrains].start();
    }
    
}
