/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.wowza.jdbc;

import fameplus.common.constants.PropertiesKey;
import fameplus.common.jdbc.dao.DBType;
import fameplus.common.jdbc.dao.Service;
import fameplus.common.util.PropertiesUtil;

/**
 *
 * @author anil
 */
public class DBService extends Service {

    public DBService() {
        this(DBType.MySQL, PropertiesUtil.fetchProperty(PropertiesKey.DB_NAME), PropertiesUtil.fetchProperty(PropertiesKey.DB_SERVER_IP), PropertiesUtil.fetchProperty(PropertiesKey.DB_USER), PropertiesUtil.fetchProperty(PropertiesKey.DB_PASSWORD));
    }

    private DBService(DBType dbType, String dbName, String dbserverIP, String uName, String uPwd) {
        super(dbType, dbName, dbserverIP, uName, uPwd);
    }
}
