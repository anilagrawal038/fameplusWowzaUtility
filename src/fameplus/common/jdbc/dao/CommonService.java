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
public class CommonService implements DAO {

    int val = 0;
    Connection con = null;

    public CommonService(Connection con1) {
        con = con1;
    }

    public int updateData(String query) {
        try {
            Statement stmt = con.createStatement();
            val = stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.updateData():" + e);
            val = 0;
        }
        return val;
    }

    public int deleteData(String query) {
        try {
            Statement stmt = con.createStatement();
            val = stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.deleteData():" + e);
            val = 0;
        }
        return val;
    }

    public int insertData(String query) {
        try {
            Statement stmt = con.createStatement();
            val = stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.insertData():" + e);
            val = 0;
        }
        return val;
    }

    public int insertObject(String table, String column, Object obj, String username) {
        try {
            String query = "update " + table + " set " + column + "=? where username=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setObject(1, (Object) obj);
            statement.setString(2, username);
            val = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.insertObject():" + e);
            val = 0;
        }
        return val;
    }

    public Result getData(String query) {
        Result result = null;
        ArrayList arrlist = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            result = ResultSupport.toResult(rs);
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.getData():" + e);
        }
        return result;
    }

    public String getStr(String query) {
        String str = "";
//query="select password from user_info where name='anil'";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                str = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.getStr():" + e);
        }
        return str;
    }

    public Object getObject(String table, String column, String username) {
        Object x = null;
        try {
            String query = "select " + column + " from " + table + " where username='" + username + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                InputStream is = rs.getBlob(1).getBinaryStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                x = ois.readObject();
            }
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.getObject():" + e);
            return e;
        }
        return x;
    }

    public int insertFile(String table, String column, InputStream blob, int length, String username) {
        try {
            String query = "update " + table + " set " + column + "=? where username=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setBinaryStream(1, blob, length);
            statement.setString(2, username);
            val = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.insertFile():" + e);
            val = 0;
        }
        return val;
    }

    public InputStream getFile(String table, String column, String username) {
        InputStream img = null;
        try {
            String query = "select " + column + " from " + table + " where username='" + username + "'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                img = rs.getBinaryStream(1);
            }
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.getFile():" + e);
        }
        return img;
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Exception in san.com.dao.Service.close():" + e);
        }
    }
}
