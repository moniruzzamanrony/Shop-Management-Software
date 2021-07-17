/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.MySqlResponse;
import dto.LoggedUserInfo;
import frames.HomeFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import logger.LoggerHelper;
import utils.AlertUtils;

/**
 *
 * @author moniruzzaman.rony
 */
public class AuthServiece extends DbConnector {

    LoggedUserInfo info;

    public LoggedUserInfo login(String phoneNo, String Password) {

        getQueryExecutor("SELECT * FROM `user` WHERE `phone_no`='" + phoneNo + "' AND `password`='" + Password + "'", new MySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {

                try {
                    if (!resultSet.isBeforeFirst()) {
                        AlertUtils.warn("Wrong phone no or password.");
                    } else {
                        while (resultSet.next()) {
                            String id = resultSet.getString("name");
                            info = new LoggedUserInfo(
                                    Integer.valueOf(resultSet.getString("id")),
                                    resultSet.getString("name"),
                                    resultSet.getString("phone_no"),
                                    resultSet.getString("email"),
                                    resultSet.getString("shop_name"),
                                    resultSet.getString("shop_address"),
                                    resultSet.getString("logo_url"),
                                    resultSet.getString("role")
                            );

                        }
                    }

                } catch (SQLException ex) {
                    throw new UnsupportedOperationException(ex);
                }
            }

            @Override
            public void onUpdateAndDeleteResponse(int result) {

            }

            @Override
            public void onError(String error) {
                LoggerHelper.error(error);
            }
        });
        return info;

    }
}
