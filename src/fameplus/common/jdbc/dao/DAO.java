/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fameplus.common.jdbc.dao;

import java.io.InputStream;
import javax.servlet.jsp.jstl.sql.Result;

/**
 *
 * @author Fighter
 */
public interface DAO {
    public int updateData(String query);
    public int insertData(String query);
    public Result getData(String query);
    public int deleteData(String query);
    public int insertObject(String table, String column, Object obj, String username);
    public String getStr(String query);
    public Object getObject(String table, String column, String username);
    public int insertFile(String table, String column, InputStream blob, int length, String username);
    public InputStream getFile(String table, String column, String username);
    public void close();
}
