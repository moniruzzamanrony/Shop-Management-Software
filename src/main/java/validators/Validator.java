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
public abstract class Validator implements ValueValidator{
    
     String value;

    public Validator(String value) {
        this.value = value;
    }
    
    
    
}
