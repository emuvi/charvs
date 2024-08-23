package br.com.pointel.charvs;

/**
 *
 * @author emuvi
 */
public class WizBase {
    
    public static final String APP_NAME = "arkhing";
    
    public static void sleep(long millis) {
        try {
            Thread.currentThread().sleep(millis);
        } catch(Exception e) {}
    }
    
    public static Thread startDaemon(Runnable task, String name) {
        var result = new Thread(task, name);
        result.setDaemon(true);
        result.start();
        return result;
    }
    
}
