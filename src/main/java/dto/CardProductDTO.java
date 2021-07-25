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
public class CardProductDTO {
    
    private String id;
    private String name;
    private String cetagory;
    private String price;
    private String qty;
    private double totalPrice;
   
    private String expDate;
    private String productLocation;

    public CardProductDTO(String id, String name, String cetagory, 
            String price, String qty, double totalPrice, String expDate,
            String productLocation) {
        this.id = id;
        this.name = name;
        this.cetagory = cetagory;
        this.price = price;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.expDate = expDate;
        this.productLocation = productLocation;
    }

    
    public String getExpDate() {
        return expDate;
    }
    
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCetagory() {
        return cetagory;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getProductLocation() {
        return productLocation;
    }
    
    
    
    
}
