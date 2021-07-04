/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import utils.AlertUtils;

/**
 *
 * @author monieuzzaman
 */
public class AppValidator {

    public static boolean isString(String value) {
        if (value == null || value.isEmpty()) {
            AlertUtils.warn("Invalid Value!!");
            return false;

        } else {

            return true;
        }
    }
}
