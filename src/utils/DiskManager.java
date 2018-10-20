package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DiskManager {
	
	private PrintWriter pw;
	
	public DiskManager() {}
	
	public void writeOnDisk(String path, String fileName, String msg) {
		try {
			pw = new PrintWriter(new FileOutputStream(new File(path + fileName), true));
			pw.append(msg);
			pw.flush();			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			pw.close();
		}
	}
}
