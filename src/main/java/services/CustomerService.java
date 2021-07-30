/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.NonReturnMySqlResponse;
import configrations.ReturnMySqlResponse;
import dto.CustomerDTO;
import dto.SupplierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import utils.AlertUtils;
import utils.ApplicationUtils;

/**
 *
 * @author moniruzzaman.rony
 */
public class CustomerService extends DbConnector {

    private Logger log = Logger.getLogger(CustomerService.class.getName());

    public void addNewCustomer(String name, String mobileNo,
            String email,
            String address) {

        String query = "INSERT INTO `customers` (`id`, `name`, `phone_no`,"
                + " `email`, "
                + "`address`, `is_active`) "
                + "VALUES ('" + ApplicationUtils.getRandomInt() + "', '"
                + name + "', '"
                + mobileNo
                + "', '" + email
                + "' , '"
                + address + "', b'1');";

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

    public List<CustomerDTO> getCustomers() {
        List<CustomerDTO> customerDTOs = new ArrayList<>();

        String query = "SELECT * FROM `customers`;";
        getQueryExecutor(query, new ReturnMySqlResponse() {

            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {
                        CustomerDTO customerDTO = new CustomerDTO();
                        customerDTO.setId(resultSet.getInt("id"));
                        customerDTO.setName(resultSet.getString("name"));
                        customerDTO.setPhoneNo(resultSet.getString("phone_no"));
                        customerDTO.setEmail(resultSet.getString("email"));
                        customerDTO.setAddress(resultSet.getString("address"));
                        customerDTO.setIsActive(resultSet.getBoolean("is_active"));

                        customerDTOs.add(customerDTO);

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

        return customerDTOs;
    }

    public CustomerDTO getCustomerByPhoneNo(String phoneNo) {

        log.info("Getting Customer Info By Phone NO:" + phoneNo);

        CustomerDTO customerDTO = new CustomerDTO();
        String query = "SELECT * FROM `customers` WHERE `phone_no` ='" + phoneNo + "';";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        customerDTO.setId(resultSet.getInt("id"));
                        customerDTO.setName(resultSet.getString("name"));
                        customerDTO.setPhoneNo(resultSet.getString("phone_no"));
                        customerDTO.setEmail(resultSet.getString("email"));
                        customerDTO.setAddress(resultSet.getString("address"));
                        customerDTO.setIsActive(resultSet.getBoolean("is_active"));
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

        log.info("Getting Customer Info from Serve" + customerDTO);
        return customerDTO;
    }

    public CustomerDTO getCustomerDetaisById(String id) {

        log.info("Getting Customer Info By Id:" + id);

        CustomerDTO customerDTO = new CustomerDTO();
        String query = "SELECT * FROM `customers` WHERE `id` ='" + id + "';";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        customerDTO.setId(resultSet.getInt("id"));
                        customerDTO.setName(resultSet.getString("name"));
                        customerDTO.setPhoneNo(resultSet.getString("phone_no"));
                        customerDTO.setEmail(resultSet.getString("email"));
                        customerDTO.setAddress(resultSet.getString("address"));
                        customerDTO.setIsActive(resultSet.getBoolean("is_active"));
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

        log.info("Getting Customer Info from Serve" + customerDTO);
        return customerDTO;
    }

}
