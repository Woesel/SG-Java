/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tenzin Woesel
 * @13th Aug, 2020
 */
package com.tenzin.guessnumber;
import  java.util.Scanner;
import java.util.Random;

public class Guess{
	
	public static void main(String[]args){
		
	Random rand = new Random();
	Scanner scan = new Scanner (System.in);

	int randomInt = rand.nextInt(100);

	System.out.println("Random Integer: " +randomInt); 

	System.out.println("Guess the random number");

	int guesses = 0;
	int guessedNum = 0;

	for(guesses=1; guessedNum != randomInt; guesses++){
		guessedNum = scan.nextInt();
		if(guessedNum>randomInt){
			System.out.println("Guess a smaller number.");
                    }else if(guessedNum<randomInt){
			System.out.println("Guess a bigger number.");
                    }else{
			System.out.println("You guessed the number correctly and it took you " +guesses+ "  tries.");
                    }
                }
        }
}
    