package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
	
	public String getEnvironmentUrl() {
		String url = properties.getProperty("environmentUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Url not specified in the Configuration.properties file.");
	}
	
	public String getUsername() {
		String username = properties.getProperty("UserName");
		if (username != null)
			return username;
		else
			throw new RuntimeException("username not specified in the Configuration.properties file.");
	}
	
	public String getPassword() {
		String password = properties.getProperty("Password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file.");
	}
	


}
