/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.jdbc;

import fameplus.common.jdbc.dao.DBType;
import fameplus.common.jdbc.dao.Service;
import fameplus.wowza.jdbc.DBService;
import java.util.Map;
import java.util.SortedMap;
import javax.servlet.jsp.jstl.sql.Result;

/**
 *
 * @author anil
 */
public class TestDAO {
    public static void main(String[] args) {
//        Service service=new Service(DBType.MySQL, "fameLive_dev", "127.0.0.1","root", "igdefault");
        DBService service=new DBService();
        Result result=service.getData("select username from user");
        System.out.println(result);
        int rowCount=result.getRowCount();
        String[] colNames=result.getColumnNames();
        SortedMap[] rows=result.getRows();
        Object[][] rowsByIndex=result.getRowsByIndex();
        for(int i=0;i<rowCount;i++){
            System.out.println("name::"+rowsByIndex[i][0]);
        }
    }
    
}
