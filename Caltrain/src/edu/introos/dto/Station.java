/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.dto;

/**
 *
 * @author Mark Christian Sanchez
 */
public class Station {
    
    private String STATION_STATUS;          // Domain: IDLE, OCCUPIED
    private String STATION_NAME;            // Optional name for Station object
    private int STATION_PASSNGERSWAITING;   // Number of Passengers waiting in the train station
    private Train TRAIN_ONSTATION;           // The current Train object in the station
    
    public Station() {
        this.Station_Init();
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
    }
    
    
}
