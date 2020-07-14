
package com.tenzin.flooring.service;

import com.tenzin.flooring.dao.FMDataPersistenceException;
import com.tenzin.flooring.dto.FMOrder;
import com.tenzin.flooring.dto.FMProduct;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tenzin Woesel
 * Jun 25, 2020
 */
public interface FMService {
    
    public List <FMOrder> getAllOrders(LocalDate orderDate) throws FMDataPersistenceException;
    
    public FMOrder addOrder(FMOrder order) throws FMDataPersistenceException, FMOrderValidationException, FMProductValidationException,FMTaxValidationException;
    
    public FMOrder getSelectedOrder(LocalDate orderDate,int orderNumber) throws FMInvalidOrderNumberException, FMDataPersistenceException; 
    
    public void removeOrder(LocalDate orderDate,int orderNumber) throws  FMDataPersistenceException;
    
    public void editOrder(FMOrder order) throws  FMDataPersistenceException;
    
    public FMOrder performCalculation(FMOrder order) throws FMDataPersistenceException, FMOrderValidationException,FMProductValidationException,FMTaxValidationException;
    
    public int generateOrderNumber();
    
    public List<FMProduct> getAllProducts() throws FMDataPersistenceException;
    
    public void validateOrder(FMOrder order) throws FMOrderValidationException, FMProductValidationException, FMTaxValidationException, FMDataPersistenceException;

}
