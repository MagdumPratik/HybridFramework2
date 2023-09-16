package Utilities;

import java.io.*;
import java.util.Properties;

public class ReadProperty {
	
	Properties pro;
	public ReadProperty()
	{
		File src=new File(".\\configuration\\config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("File not Found"+e.getMessage());
		}
	}
	public String getUrl()
	{
		String url=pro.getProperty("baseURLBS");
		return url;
	}
	
	public String getUser()
	{
		String user=pro.getProperty("UsernameBS");
		return user;
	}
	
	public String getPass()
	{
		String pass=pro.getProperty("passwordBS");
		return pass;
	}
}
