/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fameplus.common.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author anil
 */
public class UtilityLogger {
    
    private static Logger logger = Logger.getLogger("logger");
    private static Logger warn = Logger.getLogger("warnLogger");
    private static Logger info = Logger.getLogger("infoLogger");
    private static Logger trace = Logger.getLogger("traceLogger");
    private static Logger error = Logger.getLogger("errorLogger");
    private static Logger debug = Logger.getLogger("debugLogger");
    private static Logger fatal = Logger.getLogger("fatalLogger");
    private static Logger report = Logger.getLogger("reportsLogger");
    
    static {
        PropertyConfigurator.configure("log4j.properties");
    }
    
    public static void info(Object msg) {
        logger.info(msg);
        info.info(msg);
    }
    
    public static void debug(Object msg) {
        logger.debug(msg);
        debug.debug(msg);
    }
    
    public static void error(Object msg) {
        logger.error(msg);
        error.error(msg);
    }
    
    public static void fatal(Object msg) {
        logger.fatal(msg);
        fatal.fatal(msg);
    }
    
    public static void trace(Object msg) {
        logger.trace(msg);
        trace.trace(msg);
    }
    
    public static void warn(Object msg) {
        logger.warn(msg);
        warn.warn(msg);
    }
    
    public static void info(Object msg, Throwable throwable) {
        logger.info(msg, throwable);
        info.info(msg, throwable);
    }
    
    public static void debug(Object msg, Throwable throwable) {
        logger.debug(msg, throwable);
        debug.debug(msg, throwable);
    }
    
    public static void error(Object msg, Throwable throwable) {
        logger.error(msg, throwable);
        error.error(msg, throwable);
    }
    
    public static void fatal(Object msg, Throwable throwable) {
        logger.fatal(msg, throwable);
        fatal.fatal(msg, throwable);
    }
    
    public static void trace(Object msg, Throwable throwable) {
        logger.trace(msg, throwable);
        trace.trace(msg, throwable);
    }
    
    public static void warn(Object msg, Throwable throwable) {
        logger.warn(msg, throwable);
        warn.warn(msg, throwable);
    }
    
}
