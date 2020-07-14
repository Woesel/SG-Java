package com.tenzin.vendingmachine.service;

import com.tenzin.vendingmachine.dao.VendingMachineAuditDao;
import com.tenzin.vendingmachine.dao.VendingMachineDao;
import com.tenzin.vendingmachine.dao.VendingMachinePersistenceException;
import com.tenzin.vendingmachine.dto.VendingMachineItems;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tenzin Woesel
 */
public class VendingMachineServiceImplTest {

    private VendingMachineService service;

    public VendingMachineServiceImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAudiDaoStubImpl();

        service = new VendingMachineServiceImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAllItem() throws Exception {

        //ARRANGE
        VendingMachineItems testClone = new VendingMachineItems("KurKure", new BigDecimal("2.99"), 10);
        VendingMachineItems testClone1 = new VendingMachineItems("Wai Wai", new BigDecimal("3.99"), 20);
        VendingMachineItems testClone2 = new VendingMachineItems("Water", new BigDecimal("2.99"), 0);

        List<VendingMachineItems> list = service.getAllItems();
        //ACT & ASSERT
        assertEquals(2, list.size(), "Should only have 1 item.");

        assertTrue(service.getAllItems().contains(testClone));

        assertTrue(service.getAllItems().contains(testClone1));

        assertFalse(service.getAllItems().contains(testClone2));
    }

    @Test
    public void testPurchaseItem() throws Exception {
        //ARRANGE 
        VendingMachineItems onlyItem = new VendingMachineItems("KurKure", new BigDecimal("2.99"), 10);
        VendingMachineItems onlyItem1 = new VendingMachineItems("Wai Wai", new BigDecimal("3.99"), 20);
        VendingMachineItems onlyItem2 = new VendingMachineItems("Water", new BigDecimal("2.99"), 9);
        //ACT& ASSERT
        System.out.println("Test for more money");
        VendingMachineItems purchaseItem = null;
        VendingMachineItems purchaseItem1 = null;
        VendingMachineItems purchaseItem2 = null;
        try {
            purchaseItem = service.purchasedItem(onlyItem.getItemName(), new BigDecimal("100"));

        } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineInsufficientFundsException | VendingMachineNoItemInventoryException ex) {
            fail("Something is wrong.");
        }

        System.out.println("Test for enough money");
        try {
            purchaseItem1 = service.purchasedItem(onlyItem1.getItemName(), new BigDecimal("6"));
        } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineInsufficientFundsException | VendingMachineNoItemInventoryException ex) {
            fail("Something is wrong");
        }

        System.out.println("Test less money");
        try {
            purchaseItem2 = service.purchasedItem(onlyItem1.getItemName(), new BigDecimal("1"));
        } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineNoItemInventoryException ex) {
            fail("Something is wrong");
        } catch (VendingMachineInsufficientFundsException e) {
            System.out.println("Not enough money");
        }

        assertEquals(onlyItem.getNumOfItems() - 1, purchaseItem.getNumOfItems(), "Items should be the same.");

        assertEquals(onlyItem1.getItemName(), purchaseItem1.getItemName(), "Item name should be Wai Wai");
        assertEquals(onlyItem1.getItemCost(), purchaseItem1.getItemCost(), "Item costs should be the same.");

        assertNull(purchaseItem2, "Should be null.");

    }


}
