package com.tenzin.vendingmachine.service;

import com.tenzin.vendingmachine.dao.VendingMachineAuditDao;
import com.tenzin.vendingmachine.dao.VendingMachineDao;
import com.tenzin.vendingmachine.dao.VendingMachinePersistenceException;
import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Tenzin Woesel Jun 8, 2020
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    VendingMachineAuditDao auditDao;

    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao audit) {
        this.dao = dao;
        this.auditDao = audit;
    }

    @Override
    public List<VendingMachineItems> getAllItems() throws VendingMachinePersistenceException {
        List<VendingMachineItems> allItems = dao.getAllItems();
        List<VendingMachineItems> filteredItems = allItems.stream().filter(newItem -> newItem.getNumOfItems() > 0).collect(Collectors.toList());
        return filteredItems;
    }

    @Override
    public VendingMachineItems purchasedItem(String itemName, BigDecimal insertedAmount)
            throws VendingMachineNoItemInventoryException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineInsufficientFundsException {

        VendingMachineItems item = dao.getSelectedItems(itemName);
        validateVendingMachineData(item);
        if (item.getNumOfItems() == 0) {

            throw new VendingMachineNoItemInventoryException("Item not available in the inventory.");

        }
        if (insertedAmount.compareTo(item.getItemCost()) >= 0) {
            item.setNumOfItems(item.getNumOfItems() - 1);
            dao.addItem(itemName, item);
           // auditDao.writeAuditEntry(itemName + " was successfuly purchased.");
            return item;

        } else {

            throw new VendingMachineInsufficientFundsException("You have entered $" + insertedAmount + " please enter more money.");

        }
    }

    @Override
    public Map calculateChange(BigDecimal itemCost, BigDecimal insertedAmount) {

        Change change = new Change();

        BigDecimal balance = insertedAmount.subtract(itemCost);

        balance = balance.multiply(new BigDecimal("100"));

        int changeToMake = balance.intValue();

        change.calculateChange(changeToMake);

        int quarterCount = change.getQuarter();
        int dimeCount = change.getDime();
        int nickelCount = change.getNickel();
        int centCount = change.getCent();

        Map<ChangeAmounts, Integer> changeMap = new HashMap<>();

        changeMap.put(ChangeAmounts.QUARTER, quarterCount);
        changeMap.put(ChangeAmounts.DIME, dimeCount);
        changeMap.put(ChangeAmounts.NICKEL, nickelCount);
        changeMap.put(ChangeAmounts.CENT, centCount);

        //change.setNumOfCents(ChangeAmounts.CENT);
        return changeMap;
    }

    private void validateVendingMachineData(VendingMachineItems item) throws VendingMachineDataValidationException {

        if (item == null
                || item.getItemName() == null
                || item.getItemName().trim().length() == 0
                || item.getItemCost().compareTo(BigDecimal.ZERO) <= 0) { //-1less than is allowed, 0equal to is allowed, 
            throw new VendingMachineDataValidationException("Error: Item is invalid");
        }
    }

}
