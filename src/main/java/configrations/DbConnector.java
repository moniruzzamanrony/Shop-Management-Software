/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configrations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author monieuzzaman
 */
public class DbConnector {

    private final String URL = "jdbc:mysql://localhost/shop_management_db";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    public DbConnector() {

        createTable();
    }

    public Connection getConnection() {
        try {

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //JOptionPane.showMessageDialog(null, "Connection Established");
            return connection;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database server" + e);
            return null;
        }
    }

    private void createTable() {
        List<String> createTableQueries = List.of(
                "CREATE TABLE IF NOT EXISTS `user` (`id` int(11) NOT NULL auto_increment, `name` varchar(250)  NOT NULL default 'admin',`phone_no` varchar(250)  NOT NULL default 'admin',`email` varchar(250)  default '',`shop_name` varchar(250)  default '',`shop_address` varchar(250)  default '',`logo_url` varchar(250)  default '',`role` varchar(250)  default '',`password` varchar(250) NOT NULL  default 'admin',`is_active` bit NOT NULL  default 1,PRIMARY KEY  (`id`));",
                "CREATE TABLE IF NOT EXISTS `suppliers` (`id` int(11) NOT NULL, `name` varchar(250)  NOT NULL default 'admin',`phone_no` varchar(250)  NOT NULL default 'admin',`email` varchar(250)  default '',`company_name` varchar(250)  default '',`bank_name` varchar(250)  default '',`bank__ac_no` varchar(250)  default '',`address` varchar(250)  default '',`is_active` bit NOT NULL  default 1);",
                "CREATE TABLE IF NOT EXISTS `products` (`id` int(11) NOT NULL, `name` varchar(250)  NOT NULL ,`cetagory` varchar(250)  NOT NULL ,`brand` varchar(250));"
        );

        createTableQueries.forEach(res -> {

            updateOrDeleteQueryExecutor(res, new MySqlResponse() {

                @Override
                public void onError(String error) {
                    System.err.println(error);
                }

                @Override
                public void onGetResponse(ResultSet resultSet) {

                }

                @Override
                public void onUpdateAndDeleteResponse(int result) {
                    
                }
            });
        });
    }

    public void updateOrDeleteQueryExecutor(String query, MySqlResponse mySqlResponse) {
        Connection connection = getConnection();
        try {
            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            int res = st.executeUpdate(query);

            mySqlResponse.onUpdateAndDeleteResponse(res);
            st.close();
            connection.close();
        } catch (SQLException e) {
            mySqlResponse.onError(e.getMessage());

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void getQueryExecutor(String query, MySqlResponse mySqlResponse) {
        Connection connection = getConnection();
        try {
            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            mySqlResponse.onGetResponse(rs);
            st.close();
            connection.close();
        } catch (SQLException e) {
            mySqlResponse.onError(e.getMessage());

            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
