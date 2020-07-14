package com.tenzin.flooring.controller;

import com.tenzin.flooring.dao.FMDataPersistenceException;
import com.tenzin.flooring.dao.FMOrderDao;
import com.tenzin.flooring.dao.FMOrderDaoImpl;
import com.tenzin.flooring.dto.FMOrder;
import com.tenzin.flooring.dto.FMProduct;
import com.tenzin.flooring.service.FMOrderValidationException;
import com.tenzin.flooring.service.FMProductValidationException;
import com.tenzin.flooring.service.FMService;
import com.tenzin.flooring.service.FMTaxValidationException;
import com.tenzin.flooring.view.FMView;
import com.tenzin.flooring.view.UserIO;
import com.tenzin.flooring.view.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Tenzin Woesel Jun 25, 2020
 */
public class FMController {

    UserIO io = new UserIOConsoleImpl();

    private FMView view = new FMView();
    private FMOrderDao dao = new FMOrderDaoImpl();

    private FMService service;

//    public FMController(FMService service, FMView view){
//        this.service = service;
//        this.view = view;
//    }
    public void run() throws FMDataPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    io.print("Display Orders");
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    io.print("Edit Orders");
                    break;
                case 4:
                    io.print("Remove Orders");
                    break;
                case 5:
                    io.print("Export All Data");
                    break;
                case 6:
                    keepGoing = false;
                    break;
            }

        }
        io.print("Good Bye");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void getAllOrders() {
    }

    private void editOrder() {
    }

    private void addOrder() throws FMDataPersistenceException {
        List<FMProduct> listOfProducts = service.getAllProducts();
        FMOrder order = view.getNewOrderInfo(listOfProducts);
        try {
            service.validateOrder(order);
            service.addOrder(order);
        } catch (FMOrderValidationException | FMProductValidationException | FMTaxValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void removeOrder() {
    }

    private void exportAllData() {
    }

    private void unknownCommand() {
    }

    private void exitMessage() {
    }

    public void getAllProductType(String productType) throws FMDataPersistenceException {
    }
}
