/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.services;

import java.util.Random;

/**
 *
 * @author Allendale
 */
public class RobotNameGenerator {
    
    public String[] names = {
        "Adam", 
        "Klausia"
    };

    public String generateName(){
        Random rand = new Random();
    int randomNum = rand.nextInt(names.length);
    return names[randomNum];		
    } 
    
}
