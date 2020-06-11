package pers.tavish.jcip.ch7cancellationandshutdown;

import java.util.logging.Level;
import java.util.logging.Logger;

// 程序清单7-25
public class UEHLogger implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.SEVERE, "Thread terminated with exception: " + t.getName(), e);
    }
}
