
package com.tenzin.vendingmachine.service;

/**
 *
 * @author Tenzin Woesel
 * Jun 8, 2020
 */
public class VendingMachineInsufficientFundsException extends Exception {

     public VendingMachineInsufficientFundsException(String message) {
        super(message);
    }

    public VendingMachineInsufficientFundsException(String message,
            Throwable cause) {
        super(message, cause);
    }   
}
