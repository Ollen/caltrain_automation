/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.introos.services;

/**
 *
 * @author Mark Christian Sanchez
 */
public class NumberGenerator {
    public static final int MAX_INCOMING_PASSENGER = 200;
    
    
    public static int GENERATE_PASSENGER_INFLUX() {
        return (int)Math.ceil(Math.random() * MAX_INCOMING_PASSENGER);
    }
    
}
