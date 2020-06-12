package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
Properties property;
	
	/**
	 * This is a constructor where we are initializing the file from where it should read the config file
	 * and we are loading that config file using Properties class
	 */
	public ConfigReader(){
		try{
			String systemPath = System.getProperty("user.dir");
			File src = new File(systemPath + "\\src\\test\\resources\\config.properties");
			FileInputStream fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);
		}catch (Exception e){
			System.out.println("Exception while reading from Config file - " + e.getMessage());
		}
	}
	
	public String getPlatform() {
		return property.getProperty("platForm");
	}

	public String getRemoteCloud() {
		return property.getProperty("remoteCloud");
	}
	
	public String getAppiumServer() {
		return property.getProperty("appiumServer");
	}
	
	public String getAppiumPort() {
		return property.getProperty("appiumPort");
	}

}
