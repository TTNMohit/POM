package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class driverfsd implements Runnable{
	static  String port;
	    static String udid;
	public driverfsd(String portNumber, String uddid) {
        port = portNumber;
        udid = uddid;
    }
	
	
	public static WebDriver dei() throws MalformedURLException {
		WebDriver driver = null;
		try {
			//File apkpath = new File("./shiksha.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			///// Parellel execution
			
			capabilities.setCapability("deviceName", "My Mobile Device");
			capabilities.setCapability("udid", udid);
			   capabilities.setCapability("platformVersion", "6.0.0");
			
			/*
			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("VERSION", "6.0.0");
			capabilities.setCapability("deviceName", "Emulator");
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("app", "D:\\Project\\Qa-Automation\\shiksha.apk");
			//capabilities.setCapability("appPackage", "com.shiksha.android");
			//capabilities.setCapability("appActivity",'com.shiksha.android.activities.SplashScreen");
			 capabilities.setCapability("appPackage", "com.android.calculator2");
			 capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
			 driver = new RemoteWebDriver(
					new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			 */
			driver = new RemoteWebDriver(
					new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			casd(driver);
			return driver;
		} catch (Exception e) {
			System.out.println(e.toString());
			return driver;
		}
	}

	public static void casd(WebDriver driver) {
		WebElement two = driver.findElement(By.name("2"));
		two.click();
		WebElement plus = driver.findElement(By.name("+"));
		plus.click();
		WebElement four = driver.findElement(By.name("4"));
		four.click();
		WebElement equalTo = driver.findElement(By.name("="));
		equalTo.click();
		// locate the edit box of the calculator by using By.tagName()
		WebElement results = driver.findElement(By
				.className("android.widget.EditText"));

		String abb = results.getText();
	}

	@Override
	public void run() {
		try {
			dei();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
