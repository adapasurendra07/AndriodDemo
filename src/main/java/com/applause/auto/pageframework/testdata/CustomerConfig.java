package com.applause.auto.pageframework.testdata;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This class sets up all relevant customer configuration for reporting to the Applause Automation Dashboard.
 */
public class CustomerConfig {

	public static AndroidDriver driver;
	public static IOSDriver driver1;
	File classpathRoot = new File(System.getProperty("user.dir"));
	DesiredCapabilities capabilities = new DesiredCapabilities();
	/* @param browser
	*/
	@BeforeTest
	@Test(priority=1)
	public void openandriodApp() throws Exception{
		
	            classpathRoot = new File(System.getProperty("user.dir"));
	            File appDir = new File(classpathRoot, "/app/Android");
	            File app = new File (appDir, "Contacts.apk");
	            	            capabilities.setCapability("platformName", "Android");
	            capabilities.setCapability("deviceName", "JBGUCQKJDQMZCEEM");
	            capabilities.setCapability("app", app.getAbsolutePath());
	            capabilities.setCapability("appPackage","com.applause.automation.ionicconference");
	            capabilities.setCapability("appActivity","com.applause.automation.ionicconference");
	            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
	@Test(priority=2)
	public void openIOSApp() throws Exception
		{
	            classpathRoot = new File(System.getProperty("user.dir"));
	            File appDir = new File(classpathRoot, "/app/ios/");
	            File app = new File(appDir, "ionic-conference.ipa");
	            capabilities = new DesiredCapabilities();
	            capabilities.setCapability("platformName", "ios");
	            capabilities.setCapability("deviceName", "=iPhone 5s");
	            capabilities.setCapability("app", app.getAbsolutePath());
	            capabilities.setCapability("appPackage","com.applause.automation.ionicconference");
	            capabilities.setCapability("appActivity","com.applause.automation.ionicconference");
	            driver1 = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	          
	    }
	   
	

	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
	
}