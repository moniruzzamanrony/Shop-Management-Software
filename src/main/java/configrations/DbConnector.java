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

    private Connection getConnection() {
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
                "CREATE TABLE IF NOT EXISTS `invoice` ( `invoice_no` int(11) NOT NULL, `supplier_id` int(11) NOT NULL, `invoice_details_id` int(11) NOT NULL, `sub_total` double NOT NULL, `vat_in_perchance` int(11) NOT NULL, `transport_cost` double NOT NULL, `discount_in_perchance` int(11) NOT NULL, `total` float NOT NULL, `paid` float NOT NULL, `due` double NOT NULL, `invoice_type` varchar(100) NOT NULL, `created_by` int(11) NOT NULL, `creation_date_time` varchar(255) NOT NULL, `issue_date_time` varchar(255) NOT NULL )",
                "CREATE TABLE IF NOT EXISTS `invoice_details` ( `id` int(11) NOT NULL, `price` float NOT NULL, `product_id` int(11) NOT NULL, `qty` int(11) NOT NULL, `total` double NOT NULL, `expire_date` varchar(255) NOT NULL, `product_location` varchar(255) NOT NULL, `sell_discount_in_perchance` int(11) NOT NULL )",
                "CREATE TABLE IF NOT EXISTS `products` ( `id` int(11) NOT NULL, `name` varchar(250) NOT NULL, `cetagory` varchar(250) NOT NULL, `brand` varchar(250) DEFAULT NULL )",
                "CREATE TABLE IF NOT EXISTS `suppliers` ( `id` int(11) NOT NULL, `name` varchar(250) NOT NULL DEFAULT 'admin', `phone_no` varchar(250) NOT NULL DEFAULT 'admin', `email` varchar(250) DEFAULT '', `company_name` varchar(250) DEFAULT '', `bank_name` varchar(250) DEFAULT '', `bank__ac_no` varchar(250) DEFAULT '', `address` varchar(250) DEFAULT '', `is_active` bit(1) NOT NULL DEFAULT b'1' )",
                "CREATE TABLE IF NOT EXISTS `user` (`id` int(11) NOT NULL auto_increment, `name` varchar(250)  NOT NULL default 'admin',`phone_no` varchar(250)  NOT NULL default 'admin',`email` varchar(250)  default '',`shop_name` varchar(250)  default '',`shop_address` varchar(250)  default '',`logo_url` varchar(250)  default '',`role` varchar(250)  default '',`password` varchar(250) NOT NULL  default 'admin',`is_active` bit NOT NULL  default 1);",
                
                "ALTER TABLE `invoice` ADD PRIMARY KEY (`invoice_no`), ADD KEY `supplier_id` (`supplier_id`), ADD KEY `created_by` (`created_by`), ADD KEY `invoice_details_id` (`invoice_details_id`);",
                "ALTER TABLE `invoice_details` ADD PRIMARY KEY (`id`), ADD KEY `product_id` (`product_id`)",
                "ALTER TABLE `products` ADD PRIMARY KEY (`id`);",
                "ALTER TABLE `suppliers` ADD PRIMARY KEY (`id`);",
                "ALTER TABLE `user` ADD PRIMARY KEY (`id`);",
                "ALTER TABLE `user` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;",
                
                "ALTER TABLE `invoice` ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`), ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`), ADD CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`invoice_details_id`) REFERENCES `invoice_details` (`id`);",
                "ALTER TABLE `invoice_details` ADD CONSTRAINT `invoice_details_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)"
        );

        createTableQueries.forEach(res -> {

            nonReturnQueryExecutor(res, new NonReturnMySqlResponse() {

                @Override
                public void onError(String error) {
                    System.err.println(error);
                }

                @Override
                public void onUpdateAndDeleteResponse(int result) {
                    
                }
            });
        });
    }

    public void nonReturnQueryExecutor(String query, NonReturnMySqlResponse mySqlResponse) {
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

    public void getQueryExecutor(String query, ReturnMySqlResponse mySqlResponse) {
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
