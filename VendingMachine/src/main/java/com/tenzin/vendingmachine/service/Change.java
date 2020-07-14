package com.tenzin.vendingmachine.service;

import java.math.BigDecimal;

/**
 *
 * @author Tenzin Woesel Jun 9, 2020
 */
public class Change {

    int numOfCents;
    int numOfNickels;
    int numOfDimes;
    int numOfQuarters;

    public int getCent() {
        return numOfCents;
    }

    public int getNickel() {
        return numOfNickels;
    }

    public int getDime() {
        return numOfDimes;
    }

    public int getQuarter() {
        return numOfQuarters;
    }

    public void setNumOfCents(int numOfCents) {
        this.numOfCents = numOfCents;
    }

    public void setNumOfNickels(int numOfNickels) {
        this.numOfNickels = numOfNickels;
    }

    public void setNumOfDimes(int numOfDimes) {
        this.numOfDimes = numOfDimes;
    }

    public void setNumOfQuarters(int numOfQuarters) {
        this.numOfQuarters = numOfQuarters;
    }

    public void calculateChange(int balance) {

        numOfQuarters = balance / ChangeAmounts.QUARTER.getPrice();
        balance = balance % ChangeAmounts.QUARTER.getPrice();

        numOfDimes = balance / ChangeAmounts.DIME.getPrice();
        balance = balance % ChangeAmounts.DIME.getPrice();

        numOfNickels = balance / ChangeAmounts.NICKEL.getPrice();
        balance = balance % ChangeAmounts.NICKEL.getPrice();

        numOfCents = balance;

    }

}
