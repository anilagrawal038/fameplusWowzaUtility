/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.wowza.job;

import fameplus.common.util.UtilityLogger;
import fameplus.wowza.jdbc.DBService;
import fameplus.wowza.main.SMILGenerator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anil
 */
public class SMILGeneratorJob extends Thread {

    public void run() {
        DBService service = new DBService();
        SMILGenerator generator = new SMILGenerator(service);
        while (true) {
            UtilityLogger.info("Inside SMILGeneratorJob");
            System.out.println("Inside SMILGeneratorJob");
            generator.executeSMILgeneratorJob();
            UtilityLogger.info("Going to sleep for 30 Secs");
            System.out.println("Going to sleep for 30 Secs");
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SMILGeneratorJob.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception occurred in SMILGeneratorJob ::" + ex);
                UtilityLogger.debug("Exception occurred in SMILGeneratorJob ::", ex);
            }
        }
    }
}
