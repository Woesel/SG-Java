
package com.tenzin.flooring.dao;

import com.tenzin.flooring.dto.FMProduct;
import java.util.List;

/**
 *
 * @author Tenzin Woesel
 * Jun 25, 2020
 */
public interface FMProductDao {
    
    public FMProduct addProduct(FMProduct product) throws FMDataPersistenceException;
    
    public FMProduct getProduct(String productType) throws FMDataPersistenceException;
    
    public List<FMProduct> getAllProduct() throws FMDataPersistenceException;
    
    public FMProduct updateProduct(FMProduct product) throws FMDataPersistenceException;
    
    public FMProduct removeProduct(FMProduct product) throws FMDataPersistenceException;

}
