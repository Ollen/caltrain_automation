/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.dto;

import edu.introos.gui.ControlTrainPanel;
import edu.introos.main.Caltrain_X;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark Christian Sanchez
 */
public class Train implements Runnable {
    
    private String TRAIN_STATUS;      // Domain: IDLE, TRAVELING, LOADING
    private int TRAIN_NOOFSEATS;      // Maximum number of seats in the train
    private int TRAIN_NOOFPASSENGERS; // Number of Passengers in the train
    private Semaphore TRAIN_AVAILABLESEATS; // Computer by subtracting TRAIN_NOOFSEATS and TRAIN_AVAILABLESEATS
    private String TRAIN_NAME;        // Optional name of Train object
    private String TRAIN_DOORSTATUS;  // Domain: OPEN, CLOSED
    private boolean TRAIN_ISRUNNING; // Is it running?
    private final Station[] TRAIN_STATIONS;
    private ArrayList<Robot> TRAIN_PASSENGERS;
    private ArrayList<Robot> TRAIN_DROPOFFS;
    private int TRAIN_WHERE;
    private int trainID;
    
    public Train(Semaphore TRAIN_AVAILABLESEATS, int TRAIN_NOOFSEATS, String TRAIN_NAME, Station[] TRAIN_STATIONS, int id) {
        this.TRAIN_STATUS = "IDLE";
        this.TRAIN_NOOFSEATS = TRAIN_NOOFSEATS;
        this.TRAIN_NAME = TRAIN_NAME;
        this.TRAIN_NOOFPASSENGERS = 0;
        this.TRAIN_AVAILABLESEATS = TRAIN_AVAILABLESEATS;
        this.TRAIN_DOORSTATUS = "CLOSED";
        this.TRAIN_ISRUNNING = true;
        this.TRAIN_STATIONS = TRAIN_STATIONS;
        this.TRAIN_WHERE = 0;
        this.TRAIN_PASSENGERS = new ArrayList();
        this.TRAIN_DROPOFFS = new ArrayList();
        this.trainID = id;

    }
    
    @Override
    public void run() {
        System.out.println(this.TRAIN_NAME + " is created and running");
//        for(Station stations : TRAIN_STATIONS) {
//            System.out.println(stations.getSTATION_NAME());
//        }
        
        while(TRAIN_ISRUNNING) {
                
//                try {   
//                    System.out.println(this.getTRAIN_NAME() + ": " + TRAIN_STATIONS[TRAIN_WHERE].getSTATION_NAME());
//                    TRAIN_STATIONS[TRAIN_WHERE].cond_broadcast();
//                    sleep(5000);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    TRAIN_STATIONS[TRAIN_WHERE].lock_release();
//                    TRAIN_WHERE = (TRAIN_WHERE + 1) % 8;
//                }
                TRAIN_STATIONS[getTRAIN_WHERE()].setTRAIN_ONSTATION(this);
                
                System.out.println("==================================== ARRIVING ====================================");
                System.out.println("========================  WELCOME TO " + TRAIN_STATIONS[getTRAIN_WHERE()].getSTATION_NAME() + " STATION! ====================================" );
                System.out.println("+++++++++++++++++++ Waiting Passengers: " + TRAIN_STATIONS[getTRAIN_WHERE()].getSTATION_PASSNGERSWAITING());
                this.DropPassenger();
                TRAIN_STATIONS[getTRAIN_WHERE()].Station_Load_Train(this.getTRAIN_AVAILABLESEATS());
                
                try {
                    ControlTrainPanel.trainStatus.get(this.getTrainID()).setText("Travelling to " + Caltrain_X.stationNames[(getTRAIN_WHERE() + 1) % 8]);
                    Thread.sleep(1000); //Delay in Travelling
                    TRAIN_WHERE = (getTRAIN_WHERE() + 1) % 8;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            

        
    }
    
    public void AddPassenger(Robot passenger) {
        TRAIN_PASSENGERS.add(passenger);
    }
    
    public void ListPassengers() {
        for(int i = 0; i < TRAIN_PASSENGERS.size(); i++) {
            System.out.println(TRAIN_PASSENGERS.get(i) + " is in the " + this.TRAIN_NAME + " train");
        }
    }
    
    public void DropPassenger() {
        TRAIN_DROPOFFS.clear();
        for (Robot passenger : TRAIN_PASSENGERS) {
            if(passenger.getROBOT_NOOFSTATION() == 0) {
                System.out.println("It's " + passenger.getROBOT_NAME() + "'s destination, dropping off from " + TRAIN_STATIONS[getTRAIN_WHERE()].getSTATION_NAME());
                this.TRAIN_NOOFPASSENGERS--;
                TRAIN_DROPOFFS.add(passenger);
            }
            else {
                passenger.UpdateDestination();
            }
        }
        TRAIN_PASSENGERS.removeAll(TRAIN_DROPOFFS);
        TRAIN_AVAILABLESEATS.release(TRAIN_DROPOFFS.size());
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
        return TRAIN_NOOFSEATS - this.getTRAIN_AVAILABLESEATS();
    }

    /**
     * @param TRAIN_NOOFPASSENGERS the TRAIN_NOOFPASSENGERS to set
     */
    public void setTRAIN_NOOFPASSENGERS(int TRAIN_NOOFPASSENGERS) {
        this.TRAIN_NOOFPASSENGERS = TRAIN_NOOFPASSENGERS;
        ControlTrainPanel.trainSeats.get(getTrainID()).setText((this.TRAIN_NOOFPASSENGERS - 1) + "/" + this.TRAIN_NOOFSEATS);
    }

    /**
     * @return the TRAIN_AVAILABLESEATS
     */
    public int getTRAIN_AVAILABLESEATS() {
        
        return TRAIN_AVAILABLESEATS.availablePermits();
    }
    
    
    public Semaphore getSemaphore() {
        return TRAIN_AVAILABLESEATS;
    }

    /**
     * @param TRAIN_AVAILABLESEATS the TRAIN_AVAILABLESEATS to set
     */
    public void setTRAIN_AVAILABLESEATS(Semaphore TRAIN_AVAILABLESEATS) {
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

    /**
     * @return the TRAIN_DOORSTATUS
     */
    public String getTRAIN_DOORSTATUS() {
        return TRAIN_DOORSTATUS;
    }

    /**
     * @param TRAIN_DOORSTATUS the TRAIN_DOORSTATUS to set
     */
    public void setTRAIN_DOORSTATUS(String TRAIN_DOORSTATUS) {
        this.TRAIN_DOORSTATUS = TRAIN_DOORSTATUS;
    }

    /**
     * @return the TRAIN_ISRUNNING
     */
    public boolean isTRAIN_ISRUNNING() {
        return TRAIN_ISRUNNING;
    }

    /**
     * @param TRAIN_ISRUNNING the TRAIN_ISRUNNING to set
     */
    public void setTRAIN_ISRUNNING(boolean TRAIN_ISRUNNING) {
        this.TRAIN_ISRUNNING = TRAIN_ISRUNNING;
    }

    /**
     * @return the trainID
     */
    public int getTrainID() {
        return trainID;
    }

    /**
     * @return the TRAIN_WHERE
     */
    public int getTRAIN_WHERE() {
        return TRAIN_WHERE;
    }
    
    
    
    
}
