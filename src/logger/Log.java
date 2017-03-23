package logger;

import java.util.ArrayList;

import model.ProcessFile;

public class Log {
	private static Log instance;
	private int number;
	
	ArrayList<String> logStr = new ArrayList<String>();

	// private constructor, access only within class
	private Log () { ProcessFile.writeFile("log.txt",""); }

	// public getInstance()
	public static Log getInstance() {
		if (instance == null)
			instance = new Log();
		return instance;
	}

	// NextNumber get method
	public int addString(String str) {
		ProcessFile.writeFile("log.txt",str,true);
		return number;
	}
}
