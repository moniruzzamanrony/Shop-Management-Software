/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import dto.LoggedUserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import logger.LoggerHelper;
import utils.AlertUtils;
import configrations.ReturnMySqlResponse;

/**
 *
 * @author moniruzzaman.rony
 */
public class AuthServiece extends DbConnector {

    boolean isLogged = false;

    public boolean login(String phoneNo, String Password) {

        getQueryExecutor("SELECT * FROM `user` WHERE `phone_no`='" + phoneNo
                + "' AND `password`='" + Password + "'", new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {

                try {
                    if (!resultSet.isBeforeFirst()) {
                        AlertUtils.warn("Wrong phone no or password.");
                    } else {
                        while (resultSet.next()) {

                            new LoggedUserInfo(
                                    Integer.valueOf(resultSet.getString("id")),
                                    resultSet.getString("name"),
                                    resultSet.getString("phone_no"),
                                    resultSet.getString("email"),
                                    resultSet.getString("shop_name"),
                                    resultSet.getString("shop_address"),
                                    resultSet.getString("logo_url"),
                                    resultSet.getString("role")
                            );
                            isLogged = true;
                        }

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
        return isLogged;

    }
}
