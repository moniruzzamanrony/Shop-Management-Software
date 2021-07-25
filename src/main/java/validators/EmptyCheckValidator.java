/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import utils.AlertUtils;

/**
 *
 * @author moniruzzaman.rony
 */
public class EmptyCheckValidator extends Validator{

    public EmptyCheckValidator(String value) {
        super(value);
    }

    
    @Override
    public boolean validate() {
       if (value == null || value.isEmpty()) {
            return false;

        } else {

            return true;
        }
    }

    
   
    
}
