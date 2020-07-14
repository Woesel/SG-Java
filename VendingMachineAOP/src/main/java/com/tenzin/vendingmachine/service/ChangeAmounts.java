/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.vendingmachine.service;

import java.math.BigDecimal;

/**
 *
 * @author ttibe
 */
public enum ChangeAmounts {

//    CENT(new BigDecimal("1")), NICKEL(new BigDecimal("5")), DIME(new BigDecimal("10")), QUARTER(new BigDecimal("25"));
//
//    BigDecimal price;
//
//    ChangeAmounts(BigDecimal price) {
//        this.price = price;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
    CENT(1),NICKEL(5),DIME(10),QUARTER(25);
    
    int price;
    
    ChangeAmounts(int price){
        this.price = price;
    }
    
    public int getPrice(){
        return price;
    }
}
