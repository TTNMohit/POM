package Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class entry {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException,
			MalformedURLException {

		Runnable r1 = new driverfsd("5000", "192.168.90.101:5555"); // device id
																	// of first
																	// mobile
																	// device
		Runnable r2 = new driverfsd("4723", "192.168.90.102:5555"); // device id of
																	// second
																	// mobile
																	// device
		new Thread(r1).start();
		new Thread(r2).start();

		// WebDriver driver = driverfsd.dei();

		// driverfsd.casd(driver);

	}
}
