package com.tenzin.flooring.view;

import com.tenzin.flooring.dao.FMDataPersistenceException;
import com.tenzin.flooring.dto.FMOrder;
import com.tenzin.flooring.dto.FMProduct;
import com.tenzin.flooring.dto.FMTax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tenzin Woesel Jun 25, 2020
 */
public class FMView {

    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1.Display Orders");
        io.print("2.Add an Order");
        io.print("3.Edit an Order");
        io.print("4.Remove an Order");
        io.print("5.Export All Data");
        io.print("6. Quit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public void displayErrorMessage(String errorMsg) {

    }

    public void displayExitBanner() {
    }

    public void displayOrderList(List<FMOrder> orderList) {
    }

    public void displayOrderAvailableBanner() {
    }

    public void displayUnknownCommandBanner() {
    }

    public void addOrder() {
    }

    public void editOrder() {
    }

    public void removeOrder() {
    }

    public void exportAllData() {
    }

    public LocalDate getDateFromUser() {
        LocalDate date = io.readDate("Please enter date");
        return date;
    }

    public int getOrderNumber() {
        int orderNumber = io.readInt("Please enter the order number.");
        return orderNumber;
    }

    public FMOrder getNewOrderInfo(List<FMProduct> product) throws FMDataPersistenceException {

        String customerName = io.readString("Please enter the customer name");
        String state = io.readString("Please enter your state abbreviation. Ex: NY");

        for (FMProduct currentProduct : product) {
            String productInfo = String.format("%s %s %s",
                    currentProduct.getProductType(),
                    currentProduct.getCostPerSquareFoot(),
                    currentProduct.getLaborCostPerSquareFoot());
            io.print(productInfo);
        }
        String productType = io.readString("Please choose the product type");
        BigDecimal area = io.readBigDecimal("Please enter the area:");

        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName(customerName);
//        newOrder.getTaxInfo().setStateAbbreviation(state);
        FMTax taxInfo = new FMTax(state);
        newOrder.setTaxInfo(taxInfo);
        FMProduct productInfo = new FMProduct(productType);
        newOrder.setProducts(productInfo);
        newOrder.setArea(area);

        return newOrder;

    }

    public void displayOrderSummary() {
    }

    public void displayOrderSuccessful() {
    }

}
