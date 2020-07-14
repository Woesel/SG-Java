
package com.tenzin.flooring.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Tenzin Woesel
 * Jun 25, 2020
 */
public class FMProduct {
    
    public String productType;
    
    public BigDecimal costPerSquareFoot;
    
    public BigDecimal laborCostPerSquareFoot;

    public FMProduct() {
    }
    
    public FMProduct(String productType, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot) {
        this.productType = productType;
        this.costPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public FMProduct(String productType) {
        this.productType = productType;
    }
    
    public String getProductType() {
        return productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    
    

    @Override
    public String toString() {
        return "FMProduct{" + "productType=" + productType + ", costPerSquareFoot=" + costPerSquareFoot + ", laborCostPerSquareFoot=" + laborCostPerSquareFoot + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.productType);
        hash = 13 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 13 * hash + Objects.hashCode(this.laborCostPerSquareFoot);
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
        final FMProduct other = (FMProduct) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSquareFoot, other.costPerSquareFoot)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSquareFoot, other.laborCostPerSquareFoot)) {
            return false;
        }
        return true;
    }
    
    
}
