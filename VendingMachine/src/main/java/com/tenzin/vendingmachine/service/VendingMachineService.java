package com.tenzin.vendingmachine.service;

import com.tenzin.vendingmachine.dao.VendingMachinePersistenceException;
import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tenzin Woesel Jun 8, 2020
 */
public interface VendingMachineService {

   // void updateItems(VendingMachineItems item) throws VendingMachinePersistenceException, VendingMachineDataValidationException;

    List<VendingMachineItems> getAllItems() throws VendingMachinePersistenceException;

//    VendingMachineItems getSelectedItem(String itemName) throws VendingMachineNoItemInventoryException, VendingMachinePersistenceException, VendingMachineDataValidationException;

    VendingMachineItems purchasedItem(String itemName, BigDecimal insertedAmount) 
            throws VendingMachineNoItemInventoryException, 
            VendingMachinePersistenceException, 
            VendingMachineDataValidationException,
            VendingMachineInsufficientFundsException;

    Map calculateChange(BigDecimal itemCost, BigDecimal insertedAmount);

}
