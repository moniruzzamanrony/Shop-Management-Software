/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author monieuzzaman
 */
public class InvoiceDetailsDTO {
    private int id;
    private double price;
    private int product_id;
    private int qty;
    private double totalPrice;
    private String expireDate;
    private String productLocation;
    private int sellDiscount;
    private int invoiceId;

    public InvoiceDetailsDTO(int id, double price, int product_id, int qty, 
            double totalPrice, String expireDate, String productLocation, 
            int sellDiscount, int invoiceId) {
        this.id = id;
        this.price = price;
        this.product_id = product_id;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.expireDate = expireDate;
        this.productLocation = productLocation;
        this.sellDiscount = sellDiscount;
        this.invoiceId = invoiceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    public int getSellDiscount() {
        return sellDiscount;
    }

    public void setSellDiscount(int sellDiscount) {
        this.sellDiscount = sellDiscount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "InvoiceDetailsDTO{" + "id=" + id + ", price=" + price + ", product_id=" + product_id + ", qty=" + qty + ", totalPrice=" + totalPrice + ", expireDate=" + expireDate + ", productLocation=" + productLocation + ", sellDiscount=" + sellDiscount + ", invoiceId=" + invoiceId + '}';
    }
    
    
    
}
