package com.ID_Website.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getName()
	{
	String username=pro.getProperty("name");
	return username;
	}
	
	public String getEmail()
	{
	String useremail=pro.getProperty("email");
	return useremail;
	}
	
	public String getCity()
	{
	String usercity=pro.getProperty("city");
	return usercity;
	}
	
	public String getPincode()
	{
	String userpincode=pro.getProperty("pincode");
	return userpincode;
	}
	
	public String getMobileNumber()
	{
	String usermobile=pro.getProperty("mobile_num");
	return usermobile;
	}
	
	public String getOtp()
	{
	String userotp=pro.getProperty("otp");
	return userotp;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	
}




