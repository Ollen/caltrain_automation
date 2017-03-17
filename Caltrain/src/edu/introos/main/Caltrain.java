/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.main;

import edu.introos.dto.Robot;

/**
 *
 * @author Allendale
 */
public class Caltrain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main Test
        Robot robot_1 = new Robot();
        Robot robot_2 = new Robot();
        System.out.println(robot_1.getROBOT_NAME());
        System.out.println(Robot.getTOTAL_ROBOT_NUM());
        System.out.println(robot_2.getROBOT_NAME());
        System.out.println(Robot.getTOTAL_ROBOT_NUM());
    }
    
}
