package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateManager {
	
	private volatile static DateManager instance = null;
	
	private DateManager() {}
 
    public static DateManager getDateManager() {
        if (instance == null) {
            synchronized (DateManager.class){
                if (instance == null) instance = new DateManager();
            }
        }
        return instance;
    }
	
	public synchronized String getTodaysData() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		
		return dateFormat.format(cal.getTime());
	}
	
	public synchronized String getTodaysDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		return dateFormat.format(cal.getTime());
	}
	
	public synchronized long getTimestamp() {
		return new Timestamp(System.currentTimeMillis()).getTime();
	}
}
