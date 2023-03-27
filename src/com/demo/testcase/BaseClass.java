package com.demo.testcase;

import java.io.IOException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public Logger logger;

	/*
	 * before suite will contain report related setup
	 */
	@BeforeSuite(alwaysRun = true)
	public void suiteSetup() {

		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingPort(4723); // Set the port number for the Appium server
		builder.withIPAddress("0.0.0.0"); // Set the IP address of the host machine
		builder.withArgument(() -> "--no-reset"); // Add an Appium server argument
		service = AppiumDriverLocalService.buildService(builder);
		service.start(); // Start the Appium server
		// Do your testing here
	}

	/*
	 *  driver setup 
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters("On")
	public void setup(String On) throws IOException, InterruptedException {
		
		if (On.equalsIgnoreCase("local")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\ASUS\\Downloads\\IndoKargo_5.3.6_Apkpure.apk");
			// Create an instance of the AppiumDriver with the URL of the Appium server and
			// the desired capabilities
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			Thread.sleep(10000);
		}
		else {
			// code for browserstack 
		}
		
		// logger setup 
//		logger = Logger.getLogger("Automation Project Name");
//		PropertyConfigurator.configure("log4j.properties");
	}

	/*
	 *  quit mobile Driver after Every Test Execution
	 */
	@AfterMethod(alwaysRun = true)
	public void quit() {
		driver.quit();
	}

	/*
	 * report related setup tear down
	 */
	@AfterSuite(alwaysRun = true)
	public void tearDownSuite() {
		service.stop();
	}
}
