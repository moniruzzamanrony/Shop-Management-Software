/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author monieuzzaman
 */
public class ApplicationUtils {

    public static int getRandomInt() {
        Random ran = new Random();
        int x = ran.nextInt(6) + 5;
        
        return x;
    }

    public static int getRandomInvoiceNo() {
        Random ran = new Random();
        int x = ran.nextInt(6) + 15500;

        return x;
    }

    public static String getCurrentDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
