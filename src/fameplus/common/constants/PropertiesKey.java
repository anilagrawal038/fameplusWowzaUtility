/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.constants;

/**
 *
 * @author anil
 */
public enum PropertiesKey {

    DB_NAME("famePlus.dbName"),
    DB_SERVER_IP("famePlus.dbServer"),
    DB_USER("famePlus.dbUser"),
    DB_PASSWORD("famePlus.dbPassword"),
    WOWZA_CONTENT_PATH("famePlus.wowzaContentPath"),
    PID_FILE_NAME("famePlus.pidFileName");

    String value;

    PropertiesKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
