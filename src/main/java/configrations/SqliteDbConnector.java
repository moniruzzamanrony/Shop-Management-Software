/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configrations;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author monieuzzaman
 */
public class SqliteDbConnector {

    private final String JDBC_CONNECT = "jdbc:sqlite:Inventory.db";
    private final String JDBC_CLASS = "org.sqlite.JDBC";
    private final String DB_OPEN_SUCCESS = "Database connection opened successfully";
    private final String SQL_SELECT_ALL = "SELECT * FROM Inventory ORDER BY partnum ASC;";
    private final int SQL_DATABASE_ERROR = 1;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private Connection getConnection() {
        try {
            Class.forName(JDBC_CLASS);
            Connection c = DriverManager.getConnection(JDBC_CONNECT);
            System.out.println(DB_OPEN_SUCCESS);
            return c;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Database error : " + e.getMessage());
        }
        return null;
    }
}
