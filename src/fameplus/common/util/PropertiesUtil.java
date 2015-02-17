/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.util;

import fameplus.common.constants.PropertiesKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anil
 */
public class PropertiesUtil {

    static Properties prop = new Properties();

    static {
        try {
            prop.load((InputStream) new FileInputStream(new File(System.getProperty("user.dir")+"/config.properties")));
        } catch (IOException ex) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String fetchProperty(PropertiesKey key) {
        String value = null;
        if (key != null) {
            value = prop.getProperty(key.getValue());
        }
        return value;
    }
}
