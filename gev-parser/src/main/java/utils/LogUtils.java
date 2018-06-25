package utils;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imona Andoid on 13.6.2017.
 */
public class LogUtils {
    private LogUtils() {
    }

    public static void info(String msg) {
        Logger logger = Logger.getLogger("");
        logger.info(msg);
    }


    public static void error(Exception e) {
        Logger logger = Logger.getLogger("");
        String msg = "Message : " + e.getMessage() + "\n" + ExceptionUtils.getStackTrace(e);
        logger.error(msg);
    }

    public static void warning(String msg, String fileName) {
        Logger logger = Logger.getLogger(msg);
        logger.warn(msg);
    }
}
