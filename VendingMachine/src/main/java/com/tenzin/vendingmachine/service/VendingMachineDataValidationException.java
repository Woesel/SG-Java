package com.tenzin.vendingmachine.service;

/**
 *
 * @author Tenzin Woesel Jun 10, 2020
 */
public class VendingMachineDataValidationException extends Exception {

    public VendingMachineDataValidationException(String message) {
        super(message);
    }

    public VendingMachineDataValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
