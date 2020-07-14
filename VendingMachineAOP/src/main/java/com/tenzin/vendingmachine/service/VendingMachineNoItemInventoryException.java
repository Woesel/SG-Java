
package com.tenzin.vendingmachine.service;

/**
 *
 * @author Tenzin Woesel
 * Jun 8, 2020
 */
public class VendingMachineNoItemInventoryException extends Exception{
    
      public VendingMachineNoItemInventoryException(String message) {
        super(message);
    }

    public VendingMachineNoItemInventoryException(String message,
            Throwable cause) {
        super(message, cause);
    }

}
