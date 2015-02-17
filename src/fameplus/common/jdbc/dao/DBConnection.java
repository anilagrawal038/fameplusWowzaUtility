/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.jdbc.dao;

import java.sql.*;

/**
 *
 * @author Fighter
 */
public class DBConnection {

    Connection con = null;
    String driver = "";
    String url = "";
    String user = "";
    String pwd = "";

    public DBConnection() {
        driver = "org.apache.derby.jdbc.ClientDriver";
        url = "jdbc:derby://localhost:1527/sample";
        user = "app";
        pwd = "app";
    }

    public DBConnection(DBType dbType, String dbName, String dbUName, String dbPwd) {
        driver=dbType.getDriver();
        url=dbType.getURL(dbName);
        user = dbUName;
        pwd = dbPwd;
    }
    public DBConnection(DBType dbType, String dbName,String dbServer,String dbSPort, String dbUName, String dbPwd) {
        driver=dbType.getDriver();
        url=dbType.getURL(dbName,dbServer,dbSPort);
        user = dbUName;
        pwd = dbPwd;
    }
    public DBConnection(DBType dbType, String dbName,String dbServer,String dbUName, String dbPwd) {
        driver=dbType.getDriver();
        url=dbType.getURL(dbName,dbServer);
        user = dbUName;
        pwd = dbPwd;
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.DBConnection.getConnection():" + e);
        }
        return con;
    }
}
