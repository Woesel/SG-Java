/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.adder;

import java.util.Scanner;

/**
 *
 * @author Tenzin Woesel
 */
public class Adder {
    
    public static void main(String[]args){
	int sum = 0,operand1 = 0, operand2 = 0;
	
	Scanner myScanner = new Scanner(System.in);
	
	String string1 = "", string2="";
	
	System.out.println("Please enter the 1st number to be added:");
	string1 = myScanner.nextLine();
	
	System.out.println("PLease enter the 2nd number to be added:");
	string2 = myScanner.nextLine();
	
	operand1 = Integer.parseInt(string1);
	operand2 = Integer.parseInt(string2);
	
	sum = operand1 + operand2;
	
	System.out.println("Sum is :" + sum);
}
    
}
