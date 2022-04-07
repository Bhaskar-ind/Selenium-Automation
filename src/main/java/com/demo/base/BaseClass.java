package com.demo.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);
	protected static WebDriver driver;
	protected static Properties p;
	//private String url ="https://www.saucedemo.com";
	
	public Properties loadConfig() {
		//PropertyConfigurator.configure("log4j.properties");
		try {
			p = new Properties();
			log.info("Loading properties file to fetch Xpath data");
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			p.load(fi);
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		return p;
			
	}
	
	public void launchApp() {
		loadConfig();
		String browserName = p.getProperty("browser");

		    if(browserName.contains("Chrome")) {
		    	WebDriverManager.chromedriver().setup();
				log.info("Launching Chrome Driver....");
				driver = new ChromeDriver();                      //launch chrome browser
		    }else if(browserName.contains("FireFox")) {
		    	WebDriverManager.firefoxdriver().setup();
		    	driver = new FirefoxDriver();
		    }else if(browserName.contains("Edge")){
		    	WebDriverManager.edgedriver().setup();
		    	driver = new EdgeDriver();
		    }else {
		    	log.error("No Browser is selected......");
		    }
			
			driver.get(p.getProperty("url"));
			log.info("Maximizing Window of Webpage...");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	public void failedTestCases(String testMethodName) {
//		log.info("Under failedTestCase Method for failed test metod name-->"+testMethodName);
//		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy H_m_s");
//        Date sysdate = new Date();
//        log.info("Taking screenshot for method-->"+testMethodName);
//		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			System.out.println(dateFormat.format(sysdate));
//			FileUtils.copyFile(srcFile, new File("D:\\eclipse-workspace1\\LoginDemo\\ScreenShots\\"+testMethodName+"_"+dateFormat.format(sysdate)+".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}}
			
			
	

}
