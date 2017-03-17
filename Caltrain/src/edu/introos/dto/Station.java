/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.dto;

import edu.introos.services.NumberGenerator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Mark Christian Sanchez
 */
public class Station implements Runnable {
    
    private String STATION_STATUS;            // Domain: IDLE, OCCUPIED
    private String STATION_NAME;              // Optional name for Station object
    private int STATION_PASSNGERSWAITING;     // Number of Passengers waiting in the train station
    private Train TRAIN_ONSTATION;            // The current Train object in the station
    private boolean STATION_HASTRAIN; // Does the station have a train? 
    private Lock STATION_LOCK; 
    
    public Station() {
        this.Station_Init();
    }
    
    @Override
    public void run() {
        
        while(!STATION_HASTRAIN) {
            // Generate Passengers
        }
        
        while(STATION_HASTRAIN) {
            // Run critical code here
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
    
    public void cond_init() {
        
    }
    
    public void cond_wait() {
        
    }
    
    public void cond_signal() {
        
    }
    
    public void cond_broadcast() {
        
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
        return STATION_PASSNGERSWAITING;
    }

    /**
     * @param STATION_PASSNGERSWAITING the STATION_PASSNGERSWAITING to set
     */
    public void setSTATION_PASSNGERSWAITING(int STATION_PASSNGERSWAITING) {
        this.STATION_PASSNGERSWAITING = STATION_PASSNGERSWAITING;
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
    
    public boolean Station_Load_Train() {
        // Load Passengers here
        
        // Otherwise
        return false;
    }
    
    public boolean Station_Wait_For_Train() {
        // Wait for the Train to come
        
        // Critical Section here
        
        
        // Otherwise
        return false;
    }
    
    public boolean Station_On_Board() {
        // Account all passengers if they are onboard
        
        
        // Ultimately
        return true;
    }
    
    private void Station_Init() {
        this.STATION_STATUS = "IDLE";
        this.TRAIN_ONSTATION = null;
        this.STATION_PASSNGERSWAITING = 0;
        this.STATION_HASTRAIN = false;
        
    }
    
    public void Station_Add_Passengers() {
        
        this.STATION_PASSNGERSWAITING += NumberGenerator.GENERATE_PASSENGER_INFLUX();
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
