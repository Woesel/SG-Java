/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.vendingmachine.dao;

import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ttibe
 */
public class VendingMachineDaoFileImplTest {

    VendingMachineDao testDao;

    private Map<String, VendingMachineItems> vm = new HashMap<>();

    public VendingMachineDaoFileImplTest() {

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testInventory.txt";
        new FileWriter(testFile);
        testDao = new VendingMachineDaoFileImpl(testFile);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetAllItemsMethod() throws VendingMachinePersistenceException {
        //Arrange
        String itemName = "Something";
        String itemName1 = "KurKure";
        String itemName2 = "Some";
        VendingMachineItems item = new VendingMachineItems(itemName, new BigDecimal("2.99"), 10);
        VendingMachineItems item1 = new VendingMachineItems(itemName1, new BigDecimal("3.99"), 10);
        VendingMachineItems item2 = new VendingMachineItems(itemName2, new BigDecimal("1.99"), 2);

        testDao.addItem(itemName, item);
        testDao.addItem(itemName1, item1);
        testDao.addItem(itemName2, item2);

        List<VendingMachineItems> allItem = testDao.getAllItems();
        //ASSERT

        assertNotNull(allItem);
        assertEquals(3, allItem.size(), "List of items should have 3 items.");
        assertTrue(allItem.contains(item), "List should contain 'Something'");
        assertTrue(allItem.contains(item1), "List should contain 'KurKure'");
        assertTrue(allItem.contains(item2), "List should contain 'Some'");
    }

    @Test
    public void testGetSelectedItem() throws VendingMachinePersistenceException {
        //ARRANGE
        String itemName = "Something";
        String itemName1 = "KurKure";
        String itemName2 = "Some";
        VendingMachineItems item = new VendingMachineItems(itemName, new BigDecimal("2.99"), 10);
        VendingMachineItems item1 = new VendingMachineItems(itemName1, new BigDecimal("3.99"), 10);
        VendingMachineItems item2 = new VendingMachineItems(itemName2, new BigDecimal("1.99"), 2);

        testDao.addItem(itemName, item);
        testDao.addItem(itemName1, item1);
        testDao.addItem(itemName2, item2);

        //ACT
        VendingMachineItems selectedItem = testDao.getSelectedItems(itemName);
        VendingMachineItems selectedItem1 = testDao.getSelectedItems(itemName1);
        VendingMachineItems selectedItem2 = testDao.getSelectedItems(itemName2);

        assertEquals(item.getItemName(), selectedItem.getItemName(), "Name should be the same.");
        assertEquals(item.getItemCost(), selectedItem.getItemCost(), "Cost should be the same.");
        assertEquals(item.getNumOfItems(), selectedItem.getNumOfItems(), "Quantity should be same.");

        assertEquals(item1.getItemName(), selectedItem1.getItemName(), "Name should be the same.");
        assertEquals(item1.getItemCost(), selectedItem1.getItemCost(), "Cost should be the same.");
        assertEquals(item1.getNumOfItems(), selectedItem1.getNumOfItems(), "Quantity should be same.");

        assertEquals(item2.getItemName(), selectedItem2.getItemName(), "'Something' should be present.");
        assertEquals(item2.getItemCost(), selectedItem2.getItemCost(), "'Cost should be the same.");
        assertEquals(item2.getNumOfItems(), selectedItem2.getNumOfItems(), "Quantity should be same.");

    }

}
