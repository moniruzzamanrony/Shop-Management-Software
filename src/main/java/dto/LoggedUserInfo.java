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

    private static int userId;
    private static String name;
    private static String phoneNo;
    private static String email;
    private static String shopName;
    private static String shopAddress;
    private static String logoUrl;
    private static String role;

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

    public static int getUserId() {
        return userId;
    }

    public static String getName() {
        return name;
    }

    public static String getPhoneNo() {
        return phoneNo;
    }

    public static String getEmail() {
        return email;
    }

    public static String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public static String getRole() {
        return role;
    }
    
    

}
