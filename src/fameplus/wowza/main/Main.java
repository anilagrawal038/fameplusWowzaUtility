/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.wowza.main;

import fameplus.common.util.UtilityLogger;
import fameplus.wowza.job.SMILGeneratorJob;
import java.lang.management.ManagementFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author anil
 */
public class Main {    

    public static void main(String[] args) {
        
        
        String processId = ManagementFactory.getRuntimeMXBean().getName();
        UtilityLogger.info("FamePlusWowzaUtility running. With process ID :: " + processId);
        System.out.println("FamePlusWowzaUtility running. With process ID :: " + processId);
        SMILGeneratorJob job = new SMILGeneratorJob();
        job.start();
    }
}
