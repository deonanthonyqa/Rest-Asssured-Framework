package RestAssuredFramework.apiFramework.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigManager {

	public static ConfigManager conf = getSingletonConfigMangDetails();
	
	
	public static ConfigManager getSingletonConfigMangDetails() {

		if (conf == null) {
			synchronized (ConfigManager.class) {
				if (conf == null) {
					conf = new ConfigManager();// instance will be created at request time
				}
			}
		}
		return conf;
	}
	
	
	public String getPropertiesValue(String property) {
		String configPath = System.getProperty("user.dir") + "\\resources\\config.properties";
		System.out.println(configPath + "this is config path");
		FileInputStream inputStream = null;

		Properties prop = new Properties();

		try {
			inputStream = new FileInputStream(configPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
return prop.getProperty(property);

}
	
}
