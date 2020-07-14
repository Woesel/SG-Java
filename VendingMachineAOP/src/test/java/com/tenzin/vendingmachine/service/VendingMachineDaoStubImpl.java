package com.tenzin.vendingmachine.service;

import com.tenzin.vendingmachine.dao.VendingMachineDao;
import com.tenzin.vendingmachine.dao.VendingMachinePersistenceException;
import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tenzin Woesel Jun 12, 2020
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    public VendingMachineItems onlyItem, onlyItem1, onlyItem2;

    public VendingMachineDaoStubImpl() {
        onlyItem = new VendingMachineItems("KurKure", new BigDecimal("2.99"), 10);
        onlyItem1 = new VendingMachineItems("Wai Wai", new BigDecimal("3.99"), 20);
        onlyItem2 = new VendingMachineItems("Water", new BigDecimal("4.99"), 0);
    }

    public VendingMachineDaoStubImpl(VendingMachineItems testItem) {
        this.onlyItem = testItem;

    }

    @Override
    public VendingMachineItems addItem(String itemName, VendingMachineItems item) throws VendingMachinePersistenceException {
        if (itemName.equals(onlyItem.getItemName())) {
            return onlyItem; //indicates failure/updates
        }
        if (itemName.equals(onlyItem1.getItemName())) {
            return onlyItem1;
        }
        if (itemName.equals(onlyItem2.getItemName())) {
            return onlyItem2;
        } else {
            return null;//indicates successfull adding
        }

    }

    @Override
    public List<VendingMachineItems> getAllItems() throws VendingMachinePersistenceException {
        List<VendingMachineItems> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        itemList.add(onlyItem1);
        itemList.add(onlyItem2);
        return itemList;
    }

    @Override
    public VendingMachineItems getSelectedItems(String itemName) throws VendingMachinePersistenceException {
        if (itemName.equals(onlyItem.getItemName())) {
            return onlyItem;
        } else if (itemName.equals(onlyItem1.getItemName())) {
            return onlyItem1;
        } else if (itemName.equals(onlyItem2.getItemName())) {
            return onlyItem2;
        } else {
            return null;
        }
    }
}
