package com.tenzin.flooring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Tenzin Woesel Jun 25, 2020
 */
public class FMOrder {

    private LocalDate orderDate;
    private int orderNumber;
    private String customerName;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;
    private FMTax taxInfo;
    private FMProduct products;

    public FMOrder() {
    }

    public FMOrder(LocalDate orderDate, int orderNumber) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
    }

    public FMOrder(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public FMTax getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(FMTax taxInfo) {
        this.taxInfo = taxInfo;
    }

    public FMProduct getProducts() {
        return products;
    }

    public void setProducts(FMProduct products) {
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
