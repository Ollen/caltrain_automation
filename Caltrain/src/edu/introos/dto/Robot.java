/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.dto;

import edu.introos.services.RobotNameGenerator;

/**
 *
 * @author Allendale
 */
public class Robot implements Runnable {
    private static int TOTAL_ROBOT_NUM = 0;
    private String ROBOT_NAME;
    private String ROBOT_STATUS; // Stasuses: 'WAITING' & 'ONBOARD'
    private int ROBOT_NOOFSTATION; // Max of 7 stations
    
    public Robot(){
        //INCREMENT ROBOT NUM
        TOTAL_ROBOT_NUM++;
        // GENERATE RANDOM NAME
        RobotNameGenerator nameGenerator = new RobotNameGenerator();
        this.ROBOT_NAME = "[" + TOTAL_ROBOT_NUM + "]" + nameGenerator.generateName();
        this.ROBOT_STATUS = "WAITING";
    }

    @Override
    public void run() {
        
    }
    /**
     * @return the TOTAL_ROBOT_NUM
     */
    public static int getTOTAL_ROBOT_NUM() {
        return TOTAL_ROBOT_NUM;
    }

    /**
     * @return the ROBOT_NAME
     */
    public String getROBOT_NAME() {
        return ROBOT_NAME;
    }

    /**
     * @return the ROBOT_STATUS
     */
    public String getROBOT_STATUS() {
        return ROBOT_STATUS;
    }

    /**
     * @return the ROBOT_NOOFSTATION
     */
    public int getROBOT_NOOFSTATION() {
        return ROBOT_NOOFSTATION;
    }

    /**
     * @param aTOTAL_ROBOT_NUM the TOTAL_ROBOT_NUM to set
     */
    public static void setTOTAL_ROBOT_NUM(int aTOTAL_ROBOT_NUM) {
        TOTAL_ROBOT_NUM = aTOTAL_ROBOT_NUM;
    }

    /**
     * @param ROBOT_NAME the ROBOT_NAME to set
     */
    public void setROBOT_NAME(String ROBOT_NAME) {
        this.ROBOT_NAME = ROBOT_NAME;
    }

    /**
     * @param ROBOT_STATUS the ROBOT_STATUS to set
     */
    public void setROBOT_STATUS(String ROBOT_STATUS) {
        this.ROBOT_STATUS = ROBOT_STATUS;
    }

    /**
     * @param ROBOT_NOOFSTATION the ROBOT_NOOFSTATION to set
     */
    public void setROBOT_NOOFSTATION(int ROBOT_NOOFSTATION) {
        this.ROBOT_NOOFSTATION = ROBOT_NOOFSTATION;
    }
    
    
}
