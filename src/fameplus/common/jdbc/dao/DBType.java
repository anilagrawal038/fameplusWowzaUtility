/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.jdbc.dao;

import java.sql.Connection;

/**
 *
 * @author Anil Agrawal
 */
public enum DBType {

    Derby("Derby"),
    MySQL("MySQL"),
    MSSql("MSSql"),
    Oracle("Oracle"),
    Postgres("Postgres"),
    ODBC("ODBC");
    private String txt;

    DBType(String text) {
        this.txt = text;
    }

    public String getText() {
        return this.txt;
    }

    public String getDriver() {
        if (this.txt.equalsIgnoreCase("Derby")) {
            return "org.apache.derby.jdbc.ClientDriver";
        } else if (this.txt.equalsIgnoreCase("MySQL")) {
            return "com.mysql.jdbc.Driver";
        } else if (this.txt.equalsIgnoreCase("MSSql")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Oracle")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Postgres")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("ODBC")) {
            return "";
        } else {
            return "";
        }
    }

    public String getURL() {
        if (this.txt.equalsIgnoreCase("Derby")) {
            return "jdbc:derby://localhost:1527/";
        } else if (this.txt.equalsIgnoreCase("MySQL")) {
            return "jdbc:mysql://localhost:3306/";
        } else if (this.txt.equalsIgnoreCase("MSSql")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Oracle")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Postgres")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("ODBC")) {
            return "";
        } else {
            return "";
        }
    }
    public String getURL(String dbName) {
        if (this.txt.equalsIgnoreCase("Derby")) {
            return "jdbc:derby://localhost:1527/"+dbName;
        } else if (this.txt.equalsIgnoreCase("MySQL")) {
            return "jdbc:mysql://localhost:3306/"+dbName;
        } else if (this.txt.equalsIgnoreCase("MSSql")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Oracle")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Postgres")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("ODBC")) {
            return "";
        } else {
            return "";
        }
    }
    public String getURL(String dbName, String dbServer) {
        if (this.txt.equalsIgnoreCase("Derby")) {
            return "jdbc:derby://"+dbServer+":1527/"+dbName;
        } else if (this.txt.equalsIgnoreCase("MySQL")) {
            return "jdbc:mysql://"+dbServer+":3306/"+dbName;
        } else if (this.txt.equalsIgnoreCase("MSSql")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Oracle")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Postgres")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("ODBC")) {
            return "";
        } else {
            return "";
        }
    }public String getURL(String dbName, String dbServer,String dbSPort) {
        if (this.txt.equalsIgnoreCase("Derby")) {
            return "jdbc:derby://"+dbServer+":"+dbSPort+"/"+dbName;
        } else if (this.txt.equalsIgnoreCase("MySQL")) {
            return "jdbc:mysql://"+dbServer+":"+dbSPort+"/"+dbName;
        } else if (this.txt.equalsIgnoreCase("MSSql")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Oracle")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("Postgres")) {
            return "";
        } else if (this.txt.equalsIgnoreCase("ODBC")) {
            return "";
        } else {
            return "";
        }
    }

    public DAO getService(Connection con) {
        if (this.txt.equalsIgnoreCase("Derby")) {
            return new DerbyService(con);
        } else if (this.txt.equalsIgnoreCase("MySQL")) {
            return new MySQLService(con);
        } else if (this.txt.equalsIgnoreCase("MSSql")) {
            return new MSSqlService(con);
        } else if (this.txt.equalsIgnoreCase("Oracle")) {
            return new OracleService(con);
        } else if (this.txt.equalsIgnoreCase("Postgres")) {
            return new PostgresService(con);
        } else if (this.txt.equalsIgnoreCase("ODBC")) {
            return new ODBCService(con);
        } else {
            return null;
        }
    }
}
