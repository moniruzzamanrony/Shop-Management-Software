/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.NonReturnMySqlResponse;
import configrations.ReturnMySqlResponse;
import dto.SupplierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.AlertUtils;

import utils.ApplicationUtils;

/**
 *
 * @author moniruzzaman.rony
 */
public class SupplierService extends DbConnector {

    private boolean isSuccess = false;

    public boolean addNewSupplier(String name, String mobileNo,
            String email, String companyName, String bankName, String bankAcName,
            String address) {

        String query = "INSERT INTO `suppliers` (`id`, `name`, `phone_no`,"
                + " `email`, `company_name`, `bank_name`, `bank__ac_no`, "
                + "`address`, `is_active`) "
                + "VALUES ('" + ApplicationUtils.getRandomInt() + "', '"
                + name + "', '"
                + mobileNo
                + "', '" + email
                + "', '" + companyName + "', '"
                + bankName + "', '"
                + bankAcName + "', '"
                + address + "', b'1');";

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

    public List<SupplierDTO> getSuppliers() {
        List<SupplierDTO> supplierDTOs = new ArrayList<>();

        String query = "SELECT * FROM `suppliers`;";
        getQueryExecutor(query, new ReturnMySqlResponse() {

            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {
                        SupplierDTO supplierDTO = new SupplierDTO();
                        supplierDTO.setId(resultSet.getInt("id"));
                        supplierDTO.setName(resultSet.getString("name"));
                        supplierDTO.setPhoneNo(resultSet.getString("phone_no"));
                        supplierDTO.setEmail(resultSet.getString("email"));
                        supplierDTO.setCompanyName(resultSet.getString("company_name"));
                        supplierDTO.setBankName(resultSet.getString("bank_name"));
                        supplierDTO.setBankAcNo(resultSet.getString("bank__ac_no"));
                        supplierDTO.setAddress(resultSet.getString("address"));
                        supplierDTO.setIsActive(resultSet.getBoolean("is_active"));

                        supplierDTOs.add(supplierDTO);

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

        return supplierDTOs;
    }

    public SupplierDTO getByName(String name) {

        SupplierDTO supplierDTO = new SupplierDTO();
        String query = "SELECT * FROM `suppliers` WHERE `name` ='" + name + "';";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        supplierDTO.setId(resultSet.getInt("id"));
                        supplierDTO.setName(resultSet.getString("name"));
                        supplierDTO.setPhoneNo(resultSet.getString("phone_no"));
                        supplierDTO.setEmail(resultSet.getString("email"));
                        supplierDTO.setCompanyName(resultSet.getString("company_name"));
                        supplierDTO.setBankName(resultSet.getString("bank_name"));
                        supplierDTO.setBankAcNo(resultSet.getString("bank__ac_no"));
                        supplierDTO.setAddress(resultSet.getString("address"));
                        supplierDTO.setIsActive(resultSet.getBoolean("is_active"));
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
        return supplierDTO;
    }
    
     public SupplierDTO getSupplierDetaisById(String id) {
       SupplierDTO supplierDTO = new SupplierDTO();

        String query = "SELECT * FROM `suppliers` WHERE `id` ='" + id + "';";
        getQueryExecutor(query, new ReturnMySqlResponse() {

            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {
                        
                        supplierDTO.setId(resultSet.getInt("id"));
                        supplierDTO.setName(resultSet.getString("name"));
                        supplierDTO.setPhoneNo(resultSet.getString("phone_no"));
                        supplierDTO.setEmail(resultSet.getString("email"));
                        supplierDTO.setCompanyName(resultSet.getString("company_name"));
                        supplierDTO.setBankName(resultSet.getString("bank_name"));
                        supplierDTO.setBankAcNo(resultSet.getString("bank__ac_no"));
                        supplierDTO.setAddress(resultSet.getString("address"));
                        supplierDTO.setIsActive(resultSet.getBoolean("is_active"));

                      

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

        return supplierDTO;
    }
}
