package com.ttn.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ttn.main.Reports;
import com.ttn.pages.Login;

public class TestLogin {

    WebDriver driver;
    
    Login login;
    
    public void beginLoginTest(Reports rr)
    {
    	String chromePath = "D:\\Project\\POM\\";
		System.setProperty("webdriver.chrome.driver", chromePath+"chromedriver.exe");
		driver = new ChromeDriver();
    	driver.get("https://accounts.google.com/");
    	
    	String result = "";
    	login  = new Login(driver);
    	
    	
    	////Enter User Name
    	result = login.setUserName("mohit.g.shiksha@gmail.com");
    	rr.GenerateReport("1", "Login", "set username", result);
    	
    	result = login.setUserNamenext();
    	rr.GenerateReport("2", "Login", "setUserNamenext", result);
    	
    	//// Set password
    	result = login.setPassword("shiksha@123");
    	rr.GenerateReport("3", "Login", "set pasword", result);
    	
    	result = login.passnext();
    	rr.GenerateReport("4", "Login", "setUserNamenext", result);
    
    	
    }
    
}
