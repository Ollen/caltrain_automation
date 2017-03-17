/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.main;

import edu.introos.dto.Station;
import edu.introos.dto.Train;
import java.util.Scanner;

/**
 *
 * @author Allendale
 */
public class Caltrain {

    /**
     * @param args the command line arguments
     */
    
    static Thread[] stationThreads = new Thread[8];
    static Thread[] trainThreads = new Thread[16];
    static int numOfTrains = 0;
    
    public static void main(String[] args) {
       String[] stationNames = {"Taft", "Magallanes", "Ayala", "Buendia", "Guadalupe", "Boni", "Shaw", "Ortigas"}; 
       Scanner sc = new Scanner(System.in);
       
       for(int i = 0; i < 8; i++) {

           stationThreads[i] = new Thread(new Station(stationNames[i]));
           stationThreads[i].start();
       }
       
       //USER ACTION STARTS HERE
       boolean simulation = true;
       String actionCommand;
       while(simulation){
           printActions();
           actionCommand = sc.nextLine();
           
           switch (actionCommand) {
               case "1":    dispatchTrain();
                            break;
               case "2":    simulation = false;
                            break;
               default:     System.out.println("Invalid Command");
                            break;
           }
           
       }
       
        System.out.println("Simulation Ended");
        System.exit(0);

    }
    
    public static void printActions(){
        System.out.println("Number of Trains: " + numOfTrains + "/16");
        System.out.println("Actions:");
        System.out.println("[1] Dispatch a Train");
        System.out.println("[2] Finish Simulation");
    }
    
    public static void dispatchTrain(){
        boolean seats = false, name = false;
        int numOfSeats = 0;
        String trainName = null;
        Scanner sc = new Scanner(System.in);
        
        if(numOfTrains != 16){
            // Ask for the Seat
            while(!seats){

                try{
                    System.out.print("Number of Seats: ");
                    numOfSeats = Integer.parseInt(sc.nextLine());
                    if(numOfSeats > 0){
                        seats = true;
                    } else{
                        System.out.println("Please enter a positive number");
                    }
                } catch (Exception e){
                    System.out.println("Invalid Number");
                }

            }
            // Ask for the Name
            while(!name){
                System.out.print("Train Name: ");
                trainName = sc.nextLine();
                if(trainName.trim() == null || trainName.trim() == ""){
                    System.out.println("Please enter a Name");
                } else{
                    name = true;
                }
            }
            //Create The Train
            trainThreads[numOfTrains] = new Thread(new Train(numOfSeats, trainName));
            trainThreads[numOfTrains].start();
            numOfTrains++;
        } else{
            System.out.println("Maximum Train Reached");
        }
        
        
    }
    
}
