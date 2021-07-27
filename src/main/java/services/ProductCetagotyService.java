/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.NonReturnMySqlResponse;
import configrations.ReturnMySqlResponse;
import dto.ProductCetagoryDTO;
import frames.AddNewSupplierFormFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlertUtils;
import utils.ApplicationUtils;

/**
 *
 * @author moniruzzaman.rony
 */
public class ProductCetagotyService extends DbConnector {

    private boolean isSuccess = false;
 private Logger log = Logger.getLogger(ProductCetagotyService.class.getName());
 
    public boolean addNewProductNameAndCetagory(
            String produectName,
            String productCetagory,
            String productBrand) {

        String query = "INSERT INTO `products` (`id`, `name`, `cetagory`, `brand`) "
                + "VALUES ('" + ApplicationUtils.getRandomInt() + "', '"
                + produectName + "', '"
                + productCetagory + "', '"
                + productBrand + "');";

        nonReturnQueryExecutor(query, new NonReturnMySqlResponse() {

            @Override
            public void onUpdateAndDeleteResponse(int result) {
                isSuccess = true;
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });
        return isSuccess;
    }

    public List<ProductCetagoryDTO> getAll() {

        List<ProductCetagoryDTO> productCetagoryDTOs = new ArrayList<ProductCetagoryDTO>();

        String queryForProduct = "SELECT * FROM `products`;";
        getQueryExecutor(queryForProduct, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {
                        ProductCetagoryDTO productCetagoryDTO = new ProductCetagoryDTO();
                        productCetagoryDTO.setId(resultSet.getInt("id"));
                        productCetagoryDTO.setName(resultSet.getString("name"));
                        productCetagoryDTO.setCetagoty(resultSet.getString("cetagory"));
                        productCetagoryDTO.setBrand(resultSet.getString("brand"));

                        productCetagoryDTOs.add(productCetagoryDTO);

                    }
                } catch (SQLException ex) {
                    AlertUtils.error(ex.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });

        return productCetagoryDTOs;
    }

    public ProductCetagoryDTO getByName(String name) {

        ProductCetagoryDTO productCetagoryDTO = new ProductCetagoryDTO();

        String queryForProduct = "SELECT * FROM `products` WHERE `name` ='" + name + "';";
        getQueryExecutor(queryForProduct, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {
                        productCetagoryDTO.setId(resultSet.getInt("id"));
                        productCetagoryDTO.setName(resultSet.getString("name"));
                        productCetagoryDTO.setCetagoty(resultSet.getString("cetagory"));
                        productCetagoryDTO.setBrand(resultSet.getString("brand"));
                    }

                } catch (SQLException ex) {
                    AlertUtils.error(ex.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });

        return productCetagoryDTO;
    }
    
    public ProductCetagoryDTO getByProductId(int productId) {
        log.info("Product details getting By product id ="+productId);
        ProductCetagoryDTO productCetagoryDTO = new ProductCetagoryDTO();

        String queryForProduct = "SELECT * FROM `products` WHERE `id` ='" + productId + "';";
        getQueryExecutor(queryForProduct, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {
                        productCetagoryDTO.setId(resultSet.getInt("id"));
                        productCetagoryDTO.setName(resultSet.getString("name"));
                        productCetagoryDTO.setCetagoty(resultSet.getString("cetagory"));
                        productCetagoryDTO.setBrand(resultSet.getString("brand"));
                    }

                } catch (SQLException ex) {
                    AlertUtils.error(ex.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });
        log.info("Product details By product id from server "+ productCetagoryDTO);
        return productCetagoryDTO;
    }
}
