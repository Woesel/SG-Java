package com.tenzin.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Tenzin Woesel Jun 8, 2020
 */
public class VendingMachineItems {

    String itemName;
    BigDecimal itemCost;
    int numOfItems;

    public VendingMachineItems(String itemName, BigDecimal itemCost, int numOfItems) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.numOfItems = numOfItems;
    }

    public VendingMachineItems(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.itemName);
        hash = 41 * hash + Objects.hashCode(this.itemCost);
        hash = 41 * hash + this.numOfItems;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendingMachineItems other = (VendingMachineItems) obj;
        if (this.numOfItems != other.numOfItems) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCost, other.itemCost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VendingMachineItems{" + "itemName=" + itemName + ", itemCost=" + itemCost + ", numOfItems=" + numOfItems + '}';
    }

}
