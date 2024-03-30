package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility 
{
	public static String getValuesFromPropertiesFile(String propertyName)throws Exception
	{
		File file=new File("src\\test\\resources\\ConfigFiles\\config.properties");
		FileInputStream fi = new FileInputStream(file);
		Properties p=new Properties();
		String valueString="";
		try 
		{
			p.load(fi);
			p.getProperty(propertyName);
			fi.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return valueString;
	}

}
