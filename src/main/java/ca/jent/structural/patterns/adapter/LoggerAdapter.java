package ca.jent.structural.patterns.adapter;

/**
 * In another project we have seen the decorator pattern which was demonstrated
 * using a Logger.  In the adapter pattern we will reuse the simple Logger and
 * adapt it to do additional functionality.
 * In this LoggerAdapter, we will "add" the concept of log LEVEL.
 * 
 * @author jraymond
 */

public interface LoggerAdapter {
    public enum LEVEL { INFO, WARNING, ERROR }
    
    void log(String message, LEVEL level);
    
    /**
     * Here we return a Logger which has been adapted to support
     * a LEVEL.  The LEVEL for the returned Logger is fixed (i.e. capture-closure).
     * @param level
     * @return 
     */
    default Logger getLoggerWithLevel(LEVEL level) {
        return message -> log(message, level);
    }
    
    public static void main(String[] args) {
        LoggerAdapter  loggerAdapter = (message, level) -> System.out.println(level + ": " + message);
        Logger logger = loggerAdapter.getLoggerWithLevel(LoggerAdapter.LEVEL.INFO);
        // now we can use a simple Logger which has been addapted to print the LEVEL (INFO) as well.
        logger.log("This is for your information.");
    }
    
}

/** 
 * Interface has been repeated here for practical purpose. It is the same
 * interface signature as ca.jent.structural.patterns.decorator.
 */
interface Logger {
    void log(String message);
}
