/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.jdbc.dao;

import java.io.InputStream;
import java.sql.*;
import javax.servlet.jsp.jstl.sql.Result;

/**
 *
 * @author Fighter
 */
public class Service implements DAO {

    int val = 0;
    DBConnection connect = null;
    Connection con = null;
    DAO daoObj = null;

    public Service() {
        connect = new DBConnection();
        con = (Connection) connect.getConnection();
        daoObj = new DerbyService(con);
    }

    public Service(DBType dbType, String dbName, String dbUName, String dbPwd) {
        connect = new DBConnection(dbType, dbName, dbUName, dbPwd);
        con = (Connection) connect.getConnection();
        daoObj=dbType.getService(con);
    }
    public Service(DBType dbType, String dbName,String dbServer, String dbUName, String dbPwd) {
        connect=new DBConnection(dbType, dbName,dbServer,dbUName, dbPwd);
        con = (Connection) connect.getConnection();
        daoObj=dbType.getService(con);
    }

    public int updateData(String query) {
        return daoObj.updateData(query);
    }

    public int deleteData(String query) {
        return daoObj.deleteData(query);
    }

    public int insertData(String query) {
        return daoObj.insertData(query);
    }

    public int insertObject(String table, String column, Object obj, String username) {
        return daoObj.insertObject(table, column, obj, username);
    }

    public Result getData(String query) {
        return daoObj.getData(query);
    }

    public String getStr(String query) {
        return daoObj.getStr(query);
    }

    public Object getObject(String table, String column, String username) {
        return daoObj.getObject(table, column, username);
    }

    public int insertFile(String table, String column, InputStream blob, int length, String username) {
        return daoObj.insertFile(table, column, blob, length, username);
    }

    public InputStream getFile(String table, String column, String username) {
        return daoObj.getFile(table, column, username);
    }

    public void close() {
        daoObj.close();
    }
}
