/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configrations;

import java.sql.ResultSet;

/**
 *
 * @author monieuzzaman
 */
public interface ReturnMySqlResponse {
    
    void onGetResponse(ResultSet resultSet);
    
    void onError(String error);
}
