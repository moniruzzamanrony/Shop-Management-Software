/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

/**
 *
 * @author moniruzzaman.rony
 */
public class EmailValidator extends Validator{

    public EmailValidator(String value) {
        super(value);
    }

    
    @Override
    public boolean validate() {
        return true;
    }
    
}
