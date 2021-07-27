/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author moniruzzaman.rony
 */
public class ProductCetagoryDTO {

    private int id;

    private String name;

    private String cetagoty;

    private String brand;
    
    private String stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCetagoty() {
        return cetagoty;
    }

    public void setCetagoty(String cetagoty) {
        this.cetagoty = cetagoty;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    

    @Override
    public String toString() {
        return "ProductCetagoryDTO{" + "id=" + id + ", name=" + name + ", cetagoty=" + cetagoty + ", brand=" + brand + '}';
    }
    
    
}
