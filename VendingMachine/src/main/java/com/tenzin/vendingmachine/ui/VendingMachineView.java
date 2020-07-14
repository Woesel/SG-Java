package com.tenzin.vendingmachine.ui;

import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tenzin Woesel Jun 8, 2020
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Following are the items that you can get from this vending machine.");
        io.print("***************************************");
        io.print("\t\t Dairy Milk $2.99");
        io.print("\t\t M&Ms $1.99");
        io.print("\t\t Wai Wai $3.69");
        io.print("\t\t Water $2.69");
        io.print("\t\t KurKure $1.19");
        io.print("***************************************");
        io.print("1. Insert money here to buy an item.");
        io.print("2. Exit");

        return io.readInt("Please enter 1 or 2", 1, 2);
    }

    public BigDecimal insertAmount() {
        BigDecimal insertedAmount = null;
        do {
            insertedAmount = io.readBigDecimal("Please enter the dollar amount for purchasing an item");
        } while (insertedAmount == null);

        return insertedAmount;
    }

    public String chooseItemToBuy() {

        String itemName = io.readString("Please enter the name of the item you want to buy.");

        return itemName;
    }

    public void displayItemList(List<VendingMachineItems> itemList) {
        io.print("***************************************");
        itemList.stream().map((currentItem) -> String.format("%s: %s ", currentItem.getItemName(), currentItem.getItemCost())).forEachOrdered((itemInfo) -> {
            io.print(itemInfo);

        });
        io.print("***************************************");

//        for(VendingMachineItems currentItem : itemList){
//            String itemInfo = String.format("%s : %s", currentItem.getItemName(), currentItem.getItemCost());
//            io.print(itemInfo);
//        }
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void purchaseItem(String itemName, Map change) {
        boolean showChange = false;

        ArrayList<Integer> valuesList = new ArrayList(change.values());
        for (Integer integer : valuesList) {
            if (integer > 0) {
                showChange = true;
            }
        }

        if (itemName != null) {
            io.print(itemName + " is the item you purchased");
            if (showChange) {
                io.print("Here is your change back." + change);
            }

        } else {
            io.print("No such items available");
        }
    }

    public void displayItemsAvailableBanner() {
        io.print("======Following are the items available to purchase=====");
    }

//    public void getSelectedItemBanner() {
//        io.print("You have selected this item to buy.");
//    }
}
