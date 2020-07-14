package com.tenzin.vendingmachine.dao;

import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Tenzin Woesel Jun 8, 2020
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<String, VendingMachineItems> vm = new HashMap<>();

    private final String INVENTORY_FILE;

    public VendingMachineDaoFileImpl() {
        INVENTORY_FILE = "vminventory.txt";
    }

    public VendingMachineDaoFileImpl(String inventoryTextFile) {
        INVENTORY_FILE = inventoryTextFile;
    }

    public static final String DELIMETER = "::";

    @Override
    public VendingMachineItems addItem(String itemName, VendingMachineItems item) throws VendingMachinePersistenceException {
        loadInventory();
        VendingMachineItems newItem = vm.put(itemName, item);
        writeInventory();
        return newItem;
    }

    @Override
    public List<VendingMachineItems> getAllItems() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList(vm.values());
    }

    @Override
    public VendingMachineItems getSelectedItems(String itemName) throws VendingMachinePersistenceException {
        loadInventory();
        return vm.get(itemName);
    }

    private VendingMachineItems unmarshallItem(String itemAsText) {
        String[] itemTokens = itemAsText.split(DELIMETER);

        String itemName = itemTokens[0];

        VendingMachineItems itemFromFile = new VendingMachineItems(itemName);

        itemFromFile.setItemCost(new BigDecimal(itemTokens[1]));

        itemFromFile.setNumOfItems(Integer.parseInt(itemTokens[2]));

        return itemFromFile;

    }

    public void loadInventory() throws VendingMachinePersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load inventory date into memory.", e);
        }

        String currentLine;

        VendingMachineItems currentItem;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentItem = unmarshallItem(currentLine);

            vm.put(currentItem.getItemName(), currentItem);
        }
        scanner.close();
    }

    private String marshallItem(VendingMachineItems anItem) {

        String itemAsText = anItem.getItemName() + DELIMETER;

        itemAsText += anItem.getItemCost() + DELIMETER;

        itemAsText += anItem.getNumOfItems();

        return itemAsText;
    }

    public void writeInventory() throws VendingMachinePersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save item data.", e);
        }

        String itemAsText;

        List<VendingMachineItems> itemList = new ArrayList(vm.values());

        for (VendingMachineItems currentItem : itemList) {

            itemAsText = marshallItem(currentItem);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }

}
