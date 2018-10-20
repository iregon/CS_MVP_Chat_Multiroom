package utils;

import java.awt.Color;

public class LogManager {
	
    private volatile static LogManager instance = null;
    
	private String path = "logs/";
	
	private DiskManager diskManager;
	
    private LogManager() {
    	diskManager = new DiskManager();
    }
 
    public static LogManager getLogManager() {
        if (instance == null) {
            synchronized (LogManager.class){
                if (instance == null) instance = new LogManager();
            }
        }
        return instance;
    }
    
    public synchronized void appendLog(String msg) {
    	String fileName = generateFileName();
    	diskManager.writeOnDisk(path, fileName, msg);
//    	ServerViewLogManager.getInstance().appendLog(msg);
    }
    
    public synchronized void appendLogWithNewLine(String msg) {
    	String fileName = generateFileName();
    	String msg1 = msg + "\n";
    	diskManager.writeOnDisk(path, fileName, msg1);
//    	ServerViewLogManager.getInstance().appendLog(msg1);
    }
    
    public synchronized void appendErrorLogWithNewLine(String msg) {
    	String fileName = generateFileName();
    	String msg1 = ">>> ERROR\n> " + msg + "\n";
    	diskManager.writeOnDisk(path, fileName, msg1);
//    	ServerViewLogManager.getInstance().appendErrorLogWithNewLine(msg1);
    }
    
    public synchronized void appendLogWithNewLineAndColor(String msg, Color color) {
    	String fileName = generateFileName();
    	String msg1 = msg + "\n";
    	diskManager.writeOnDisk(path, fileName, msg1);
//    	ServerViewLogManager.getInstance().appendLogWithNewLineAndColor(msg1, color);
    }
    
    private String generateFileName() {
    	String date = DateManager.getDateManager().getTodaysData();
		
		String file = "log_" + date + ".dat";
		
		return file;
    }
}
