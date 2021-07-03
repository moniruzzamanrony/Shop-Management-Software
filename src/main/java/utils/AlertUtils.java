/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author monieuzzaman
 */
public class AlertUtils {

    public static void success(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warn(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void error(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirmation(String message) {
        int n = JOptionPane.showConfirmDialog(
                null,
                "Are you sure ?",
                message,
                JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
