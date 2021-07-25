/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import validators.Validator;

/**
 *
 * @author moniruzzaman.rony
 */
public class ValidatorService {
    
    public boolean validate(List<Validator> validators)
    {
        for(Validator validator: validators)
        {
            if(!validator.validate())
            {
            return false;
            }
        }
    return true;
    }
}
