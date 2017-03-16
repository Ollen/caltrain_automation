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
public class Train {
    
    private String TRAIN_STATUS;
    private int TRAIN_NOOFSEATS;
    private int TRAIN_NOOFPASSENGERS;
    private int TRAIN_AVAILABLESEATS;
    private String TRAIN_NAME;
    
    public Train(int TRAIN_NOOFSEATS, String TRAIN_NAME) {
        this.TRAIN_STATUS = "IDLE";
        this.TRAIN_NOOFSEATS = TRAIN_NOOFSEATS;
        this.TRAIN_NAME = TRAIN_NAME;
        this.TRAIN_NOOFPASSENGERS = 0;
        this.TRAIN_AVAILABLESEATS = this.TRAIN_NOOFSEATS;

    }

    /**
     * @return the TRAIN_STATUS
     */
    public String getTRAIN_STATUS() {
        return TRAIN_STATUS;
    }

    /**
     * @param TRAIN_STATUS the TRAIN_STATUS to set
     */
    public void setTRAIN_STATUS(String TRAIN_STATUS) {
        this.TRAIN_STATUS = TRAIN_STATUS;
    }

    /**
     * @return the TRAIN_NOOFSEATS
     */
    public int getTRAIN_NOOFSEATS() {
        return TRAIN_NOOFSEATS;
    }

    /**
     * @param TRAIN_NOOFSEATS the TRAIN_NOOFSEATS to set
     */
    public void setTRAIN_NOOFSEATS(int TRAIN_NOOFSEATS) {
        this.TRAIN_NOOFSEATS = TRAIN_NOOFSEATS;
    }

    /**
     * @return the TRAIN_NOOFPASSENGERS
     */
    public int getTRAIN_NOOFPASSENGERS() {
        return TRAIN_NOOFPASSENGERS;
    }

    /**
     * @param TRAIN_NOOFPASSENGERS the TRAIN_NOOFPASSENGERS to set
     */
    public void setTRAIN_NOOFPASSENGERS(int TRAIN_NOOFPASSENGERS) {
        this.TRAIN_NOOFPASSENGERS = TRAIN_NOOFPASSENGERS;
    }

    /**
     * @return the TRAIN_AVAILABLESEATS
     */
    public int getTRAIN_AVAILABLESEATS() {
        TRAIN_AVAILABLESEATS = this.TRAIN_NOOFSEATS - this.TRAIN_NOOFPASSENGERS;
        return TRAIN_AVAILABLESEATS;
    }

    /**
     * @param TRAIN_AVAILABLESEATS the TRAIN_AVAILABLESEATS to set
     */
    public void setTRAIN_AVAILABLESEATS(int TRAIN_AVAILABLESEATS) {
        this.TRAIN_AVAILABLESEATS = TRAIN_AVAILABLESEATS;
    }

    /**
     * @return the TRAIN_NAME
     */
    public String getTRAIN_NAME() {
        return TRAIN_NAME;
    }

    /**
     * @param TRAIN_NAME the TRAIN_NAME to set
     */
    public void setTRAIN_NAME(String TRAIN_NAME) {
        this.TRAIN_NAME = TRAIN_NAME;
    }
    
    
}
