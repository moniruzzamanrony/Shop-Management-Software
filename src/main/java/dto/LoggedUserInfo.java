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
public class LoggedUserInfo {

    private int userId;
    private String name;
    private String phoneNo;
    private String email;
    private String shopName;
    private String shopAddress;
    private String logoUrl;
    private String role;

    public LoggedUserInfo(int userId, String name, String phoneNo, String email,
            String shopName, String shopAddress, String logoUrl, String role) {
        this.userId = userId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.logoUrl = logoUrl;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getRole() {
        return role;
    }
    
    

}
