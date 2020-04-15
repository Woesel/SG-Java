/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.exercise2;

/**
 *
 * @author Tenzin Woesel
 */
public class MoreBucketsMoreFun {
    
    public static void main(String[] args) {
        
        //Declare all the things 
        //(Usually it's a good idea to declare them at the beginning of the program)
        
        int butterflies, beetles, bugs;
        
        butterflies = 5;
        beetles = 9;
        
        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println("but there are "+ bugs +" bugs in all.");
        
        System.out.println("Uh oh, my dog ate one.");
        butterflies--;
        
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But there are still " + bugs + " bugs left...");
        System.out.println("Wait a minute!");
        System.out.println("May be my computer can't do math after all!");
    }
    
}
