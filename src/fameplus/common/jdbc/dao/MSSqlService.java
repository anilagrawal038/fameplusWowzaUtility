/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.jdbc.dao;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 *
 * @author Anil Agrawal
 */
public class MSSqlService  implements DAO {
   int val = 0;
    Connection con = null;
    DAO daoObj = null;

    public MSSqlService(Connection con1) {
        con = con1;
        daoObj = new CommonService(con);
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
