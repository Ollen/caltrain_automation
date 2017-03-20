/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.dto;

import edu.introos.services.NumberGenerator;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark Christian Sanchez
 */
public class Station {
    
    private String STATION_STATUS;            // Domain: IDLE, OCCUPIED
    private String STATION_NAME;              // Optional name for Station object
    private int STATION_PASSENGERSWAITING;     // Number of Passengers waiting in the train station
    private Train TRAIN_ONSTATION;            // The current Train object in the station
    private boolean STATION_HASTRAIN;         // Does the station have a train? 
    private Lock STATION_LOCK;
    private Condition STATION_CONDITION;
    private ArrayList<Thread> STATION_ROBOTS;
    private ArrayList<Robot> ROBOT_OBJECT;
    
    
    public Station(String STATION_NAME) {
        this.Station_Init(STATION_NAME);
        
    }
    
    private void GeneratePassengers(int STATION_PASSENGERSWAITING) {
        for(int i = 0; i < STATION_PASSENGERSWAITING; i++){
            //thread[i] = new Thread(new Robot());
            Robot passenger = new Robot(this);
            ROBOT_OBJECT.add(passenger);
            STATION_ROBOTS.add(new Thread(passenger));
            
        }
        for(Thread robot : STATION_ROBOTS) {
            robot.start();
        }
    }
    
    private void Station_Init(String STATION_NAME) {
        this.STATION_STATUS = "IDLE";
        this.TRAIN_ONSTATION = null;
        this.STATION_PASSENGERSWAITING = 0;
        this.STATION_HASTRAIN = false;
        this.STATION_NAME = STATION_NAME;
        this.ROBOT_OBJECT = new ArrayList();
        this.STATION_ROBOTS = new ArrayList();
        
        // Generate Passengers/Robots
        STATION_PASSENGERSWAITING = NumberGenerator.GENERATE_PASSENGER_INFLUX();
        System.out.println(STATION_NAME + ": " + STATION_PASSENGERSWAITING + " Passengers");
        // CREATE ROBOTS/PASENGERS
        this.lock_init();
        this.cond_init();
        this.GeneratePassengers(STATION_PASSENGERSWAITING);
        

    }
    
    public void Station_Load_Train(int TRAIN_AVAILABLESEATS) {
        // Load Train
        
        this.lock_acquire();
        // Start Critical Section
        System.out.println(TRAIN_ONSTATION.getTRAIN_NAME() + " is arriving at " + this.getSTATION_NAME() + " station.");
        System.out.println("Train doors have opened!");
        if(STATION_PASSENGERSWAITING == 0) {
            System.out.println("No passengers in " + this.getSTATION_NAME());                       
            int influx = NumberGenerator.GENERATE_PASSENGER_INFLUX();
        }
        else if(TRAIN_AVAILABLESEATS == 0) {
            System.out.println("No more seats! Train is leaving.");
            
        }
        else {
            System.out.println("Passengers boarding!");
            this.cond_broadcast();
            
            
        }
        // End Critical Section
        this.lock_release();
        // Otherwise
      
    }
    
    public void Station_Wait_For_Train(Robot passenger) {
        this.lock_acquire();
        this.cond_wait();
        this.lock_release();
        this.Station_On_Board(passenger);
       
        
    }
    
    public void Station_On_Board(Robot passenger) {
        // Account all passengers if they are onboard
        this.lock_acquire();
        
        try {
                if(TRAIN_ONSTATION.getTRAIN_AVAILABLESEATS() == 0) {
                //Wait for another train

                this.lock_release();
                // Sleep again
                Station_Wait_For_Train(passenger);
            }
            else {
                this.STATION_PASSENGERSWAITING--;
                int currNoOfPassengers = TRAIN_ONSTATION.getTRAIN_NOOFPASSENGERS() + 1;
                TRAIN_ONSTATION.setTRAIN_NOOFPASSENGERS(currNoOfPassengers);
                TRAIN_ONSTATION.AddPassenger(passenger);
                ROBOT_OBJECT.remove(passenger);
                System.out.println(passenger.getROBOT_NAME() + " boarded the train");
                System.out.println("Number of available seats of train: " + TRAIN_ONSTATION.getTRAIN_AVAILABLESEATS() + " Train: " + TRAIN_ONSTATION.getTRAIN_NAME());
                System.out.println("Number of Passengers = " + TRAIN_ONSTATION.getTRAIN_NOOFPASSENGERS());
                this.lock_release();
            }
        }
        finally {
            
            // Ultimately
        }
        
        
        
    }
    
    public void lock_init() {
        STATION_LOCK = new ReentrantLock();
    }
    
    public void lock_acquire() {
        STATION_LOCK.lock();
    }
    
    public void lock_release() {
        STATION_LOCK.unlock();
    }
    
    public  void cond_init() {
        STATION_CONDITION = STATION_LOCK.newCondition();
    }
    
    public void cond_wait() {
        try {
              STATION_CONDITION.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void cond_signal() {
        STATION_CONDITION.signal();
        
    }
    
    public void cond_broadcast() {
        STATION_CONDITION.signalAll();
    }

    /**
     * @return the STATION_STATUS
     */
    public String getSTATION_STATUS() {
        return STATION_STATUS;
    }

    /**
     * @param STATION_STATUS the STATION_STATUS to set
     */
    public void setSTATION_STATUS(String STATION_STATUS) {
        this.STATION_STATUS = STATION_STATUS;
    }

    /**
     * @return the STATION_NAME
     */
    public String getSTATION_NAME() {
        return STATION_NAME;
    }

    /**
     * @param STATION_NAME the STATION_NAME to set
     */
    public void setSTATION_NAME(String STATION_NAME) {
        this.STATION_NAME = STATION_NAME;
    }

    /**
     * @return the STATION_PASSNGERSWAITING
     */
    public int getSTATION_PASSNGERSWAITING() {
        return STATION_PASSENGERSWAITING;
    }

    /**
     * @param STATION_PASSNGERSWAITING the STATION_PASSNGERSWAITING to set
     */
    public void setSTATION_PASSNGERSWAITING(int STATION_PASSNGERSWAITING) {
        this.STATION_PASSENGERSWAITING = STATION_PASSNGERSWAITING;
    }

    /**
     * @return the TRAIN_ONSTATION
     */
    public Train getTRAIN_ONSTATION() {
        return TRAIN_ONSTATION;
    }

    /**
     * @param TRAIN_ONSTATION the TRAIN_ONSTATION to set
     */
    public void setTRAIN_ONSTATION(Train TRAIN_ONSTATION) {
        this.TRAIN_ONSTATION = TRAIN_ONSTATION;
    }
       
    public void Station_Add_Passengers() {
        
        this.STATION_PASSENGERSWAITING += NumberGenerator.GENERATE_PASSENGER_INFLUX();
    }

    /**
     * @return the STATION_HASTRAIN
     */
    public boolean isSTATION_HASTRAIN() {
        return STATION_HASTRAIN;
    }

    /**
     * @param STATION_HASTRAIN the STATION_HASTRAIN to set
     */
    public void setSTATION_HASTRAIN(boolean STATION_HASTRAIN) {
        this.STATION_HASTRAIN = STATION_HASTRAIN;
    }
    
    
}
