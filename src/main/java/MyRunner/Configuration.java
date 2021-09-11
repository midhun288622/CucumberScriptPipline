package MyRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static String configFilePath=(System.getProperty("user.dir")+"\\project-bootstrap.properties").replace("\\",System.getProperty("file.separator"));
	private static final Configuration CONFIG=new Configuration();
	private final Properties myProps;
	
	private Configuration()
	{
		System.out.println("Curent config file "+configFilePath);
		myProps=new Properties();
		try {
			myProps.load(getFileInputStream(configFilePath));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		myProps.putAll(System.getProperties());
	}
	
	
	
	public FileInputStream getFileInputStream(String fileName) throws FileNotFoundException
	
	{
		return new FileInputStream(fileName);
	}
	
	public static Configuration getConfiguration()
	{
		return CONFIG;
	}
	
	public String getProperty(String keyPart)
	{
		return getProperty(keyPart,null);
		
	}
	public String getProperty(String keyPart,String defualValue)
	{
		return myProps.getProperty(keyPart,defualValue);
		
	}
}
