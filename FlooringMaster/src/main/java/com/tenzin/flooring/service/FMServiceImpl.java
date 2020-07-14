package com.tenzin.flooring.service;

import com.tenzin.flooring.dao.FMOrderAuditDao;
import com.tenzin.flooring.dao.FMOrderDao;
import com.tenzin.flooring.dao.FMDataPersistenceException;
import com.tenzin.flooring.dao.FMProductDao;
import com.tenzin.flooring.dao.FMTaxDao;
import com.tenzin.flooring.dto.FMOrder;
import com.tenzin.flooring.dto.FMProduct;
import com.tenzin.flooring.dto.FMTax;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tenzin Woesel Jul 7, 2020
 */
public class FMServiceImpl implements FMService {

    public FMOrderAuditDao auditDao;
    public FMOrderDao dao;
    public FMProductDao pDao;
    public FMTaxDao taxDao;

    @Override
    public List<FMOrder> getAllOrders(LocalDate orderDate) throws FMDataPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FMOrder addOrder(FMOrder order) throws FMDataPersistenceException, FMOrderValidationException, FMProductValidationException, FMTaxValidationException{
        validateOrder(order);
        return dao.addOrder(order);

    }

    @Override
    public FMOrder getSelectedOrder(LocalDate orderDate, int orderNumber) throws FMInvalidOrderNumberException, FMDataPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOrder(LocalDate orderDate, int orderNumber) throws FMDataPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editOrder(FMOrder order) throws FMDataPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FMOrder performCalculation(FMOrder order) throws FMDataPersistenceException, FMOrderValidationException, FMProductValidationException, FMTaxValidationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int generateOrderNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validateOrder(FMOrder order) throws
            FMOrderValidationException,
            FMProductValidationException,
            FMTaxValidationException,
            FMDataPersistenceException {
        if (order.getCustomerName() == null
                || order.getTaxInfo().getStateAbbreviation().isBlank()
                || order.getTaxInfo().getStateAbbreviation().isBlank()
                || order.getProducts().getProductType().isEmpty()) {
            throw new FMOrderValidationException("Error: All fields are required");
        }
        if (order.getOrderDate().isBefore(LocalDate.now())) {
            throw new FMOrderValidationException("Date must be after today");
        }

        //how can I see all of the states to see if the user gave me a state that exists
        FMTax newTax = taxDao.getTax(order.getTaxInfo().getStateAbbreviation());
        if (newTax == null) {
            throw new FMOrderValidationException("Error: We do not sell in your place.");
        }

        //if the date is after today
        //if the product type is in the system.
        //if the tax state is in the system
        //if the name is correct - meaning it is only certain characters
        //if the area is greater than 100
    }

    @Override
    public List<FMProduct> getAllProducts() throws FMDataPersistenceException {
        List<FMProduct> allProduct = pDao.getAllProduct();
        return allProduct;
    }

}
