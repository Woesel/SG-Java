package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMProduct;
import com.tenzin.flooring.dto.FMTax;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Tenzin Woesel Jun 25, 2020
 */
public interface FMTaxDao {

    public FMTax addTax(FMTax tax) throws FMDataPersistenceException;

    public FMTax getTax(String stateAbbreviation) throws FMDataPersistenceException;

    public List<FMProduct> getAllTax() throws FMDataPersistenceException;

    public FMTax updateTax(FMTax tax) throws FMDataPersistenceException;

    public FMTax removeTax(FMTax tax) throws FMDataPersistenceException;
}
