/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.wowza.main;

import fameplus.common.constants.PropertiesKey;
import fameplus.common.util.PropertiesUtil;
import fameplus.common.util.UtilityLogger;
import fameplus.wowza.job.SMILGeneratorJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author anil
 */
public class Main {

    public static void main(String[] args) {

        String processId = ManagementFactory.getRuntimeMXBean().getName();
        FileWriter fWriter = null;
        try {
            String filePath = System.getProperty("user.dir") + "/" + PropertiesUtil.fetchProperty(PropertiesKey.PID_FILE_NAME);
            UtilityLogger.info("PID file path : " + filePath);
            fWriter = new FileWriter(filePath, true);
            fWriter.append(("\nProcess PID (" + (new Date()) + ") : " + processId));
        } catch (IOException ex) {
            UtilityLogger.debug("Exception while appending process PID", ex);
            ex.printStackTrace();
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            UtilityLogger.debug("Exception while appending process PID", e);
            e.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                UtilityLogger.debug("Exception while appending process PID", ex);
                java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        UtilityLogger.info("FamePlusWowzaUtility running. With process ID :: " + processId);
        System.out.println("FamePlusWowzaUtility running. With process ID :: " + processId);
        SMILGeneratorJob job = new SMILGeneratorJob();
        job.start();
    }
}
