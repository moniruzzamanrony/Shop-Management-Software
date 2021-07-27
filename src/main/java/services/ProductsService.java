/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.ReturnMySqlResponse;
import dto.InvoiceDetailsDTO;
import dto.ProductDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlertUtils;

/**
 *
 * @author moniruzzaman.rony
 */
public class ProductsService extends DbConnector {

    private Logger log = Logger.getLogger(ProductsService.class.getName());
    private ProductDTO productDTO;

    public ProductDTO getProductById(String productId) {
//        log.info("Product List getting by productId " + productId);
//
//        String query = "SELECT * FROM `invoice_details` WHERE `product_id`='" + productId + "'";
//
//        getQueryExecutor(query, new ReturnMySqlResponse() {
//            @Override
//            public void onGetResponse(ResultSet resultSet) {
//                try {
//                    while (resultSet.next()) {
//
//                        productDTO = new ProductDTO(
//                                resultSet.getInt("id"),
//                                resultSet.getDouble("price"),
//                                resultSet.getInt("product_id"),
//                                resultSet.getInt("qty"),
//                                resultSet.getString("expire_date"),
//                                resultSet.getString("product_location"),
//                                resultSet.getInt("sell_discount_in_perchance"),
//                                resultSet.getInt("invoice_id")
//                        );
//
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            @Override
//            public void onError(String error) {
//                AlertUtils.error(error);
//            }
//        });
//
//        log.info("Product List get from server " + invoiceDetailsDTOs);
//
        return productDTO;

    }
}
