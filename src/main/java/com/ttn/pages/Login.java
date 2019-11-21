package com.ttn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	
	By password = By.xpath(".//*[@id='password']/div[1]/div/div[1]/input");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public String setUserName(String strUserName) {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(
					strUserName);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}

	public String setUserNamenext() {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='identifierNext']")).click();
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}

	public String passnext() {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='passwordNext']/content"))
					.click();
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}

	public String setPassword(String strPassword) {
		try {
			Thread.sleep(5000);
			driver.findElement(password).sendKeys(strPassword);
			return "true";
		} catch (Exception e) {
			return "false";
		}
	}

	
}
