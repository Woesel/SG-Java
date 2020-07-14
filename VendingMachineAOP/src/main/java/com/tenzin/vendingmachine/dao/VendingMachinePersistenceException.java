
package com.tenzin.vendingmachine.dao;

/**
 *
 * @author Tenzin Woesel
 * Jun 9, 2020
 */
public class VendingMachinePersistenceException extends Exception{
    
     public VendingMachinePersistenceException(String message) {
        super(message);
    }

    public VendingMachinePersistenceException(String message, Throwable cause) {

        super(message, cause);
    }

}
