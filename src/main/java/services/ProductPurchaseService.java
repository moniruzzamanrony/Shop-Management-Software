/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.NonReturnMySqlResponse;
import dto.InvoiceDTO;
import utils.AlertUtils;

/**
 *
 * @author monieuzzaman
 */
public class ProductPurchaseService extends DbConnector implements InvoiceService {

    @Override
    public void saveInvoice(InvoiceDTO invoiceDTO) {

        String query = "";
        
        nonReturnQueryExecutor(query, new NonReturnMySqlResponse() {

            @Override
            public void onUpdateAndDeleteResponse(int result) {
               

            }

            @Override
            public void onError(String error) {

                AlertUtils.error(error);
            }
        });

    }

}
