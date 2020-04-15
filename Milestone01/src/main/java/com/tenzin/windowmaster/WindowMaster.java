/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.windowmaster;

import java.util.Scanner;

/**
 *
 * @author ttibe
 */
public class WindowMaster {
    public static void main(String[]args){
        float height;
        float width;
        float numWindows;
        float trimCost;
        float glassCost;
        
        String stringHeight;
        String stringWidth;
        String stringWindows;
        String stringTrimCost;
        String stringGlassCost;
        
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter the height of window:");
        stringHeight = sc.nextLine();
        
        System.out.println("Please enter the width of window:");
        stringWidth = sc.nextLine();
        
        System.out.println("Please enter the number of windows");
        stringWindows = sc.nextLine();
        
        System.out.println("Please enter the glass cost:");
        stringGlassCost = sc.nextLine();
        
        System.out.println("Please enter the trim cost:");
        stringTrimCost = sc.nextLine();
        
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        numWindows = Float.parseFloat(stringWindows);
        glassCost = Float.parseFloat(stringGlassCost);
        trimCost = Float.parseFloat(stringTrimCost);
        
        areaOfWindow = height*width;
        perimeterOfWindow = 2 * (height+width);
        
        //cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow) * numWindows;
        cost = (glassCost * areaOfWindow) + (trimCost * perimeterOfWindow) * numWindows;
        
        System.out.println("Window height = "+ height);
        System.out.println("Window Width = "+ width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total cost = $" + cost);
        
        
    }
    
}
