package com.ttn.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class mainclass {

	public static void main(String[] args) throws InterruptedException {

		// ExcelRead rr = new ExcelRead();
		// rr.ReadMyExcel();

		WebDriver driver;
		String chromePath = "D:\\Project\\POM\\";
		System.setProperty("webdriver.chrome.driver", chromePath
				+ "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.automationtesting.in/Register.html");

		// // Title
		String title = driver.getTitle();
		System.out.println(title);

		// // url
		String url = driver.getCurrentUrl();
		System.out.println(url);

		// // Common Commands
		List<WebElement> we = driver.findElements(By
				.xpath(".//*[@id='basicBootstrapForm']//input"));

		for (WebElement webElement : we) {
			String abc = webElement.getText();
			System.out.println(abc);
			webElement.click();
		}

		// // Select
		Select oSelect = new Select(driver.findElement(By.id("Skills")));
		// // Explain other options
		oSelect.selectByIndex(2);

		// // Get
		List<WebElement> we1 = driver.findElements(By
				.xpath(".//*[@id='basicBootstrapForm']//label"));

		for (WebElement webElement : we1) {
			String abc = webElement.getText();
			String abc2 = webElement.getAttribute("class");
			System.out.println(abc + abc2);
		}

		// // Fill complete form
		driver.findElement(By.xpath(".//*[@placeholder='First Name']"))
				.sendKeys("Test");
		driver.findElement(By.xpath(".//*[@placeholder='Last Name']"))
				.sendKeys("QA");
		driver.findElement(By.xpath(".//*[@id='basicBootstrapForm']//textarea"))
				.sendKeys("sec 127, noida");
		driver.findElement(By.xpath(".//*[@id='eid']/input")).sendKeys(
				"ttnttn@ttn.com");
		driver.findElement(
				By.xpath(".//*[@id='basicBootstrapForm']/div[4]/div/input"))
				.sendKeys("9876543210");
		driver.findElement(By.xpath(".//*[@value='Male']")).click();
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("msdd")).click();
		Thread.sleep(1000);

		List<WebElement> lang = driver.findElements(By
				.xpath(".//*[@id='basicBootstrapForm']//ul"));
		for (WebElement webElement : lang) {
			webElement.click();
			Thread.sleep(100);
			break;
		}

		Select oSelecet = new Select(driver.findElement(By.id("Skills")));
		oSelecet.selectByIndex(2);

		Select d = new Select(driver.findElement(By.id("countries")));
		d.selectByVisibleText("India");

		// // DOB
		Select dd = new Select(driver.findElement(By.id("yearbox")));
		dd.selectByIndex(1);

		Select dde = new Select(driver.findElement(By
				.xpath(".//*[@placeholder='Month']")));
		dde.selectByIndex(1);

		Select dddd = new Select(driver.findElement(By.id("daybox")));
		dddd.selectByIndex(1);

		driver.findElement(By.id("firstpassword")).sendKeys("Tothenew123");
		driver.findElement(By.id("secondpassword")).sendKeys("Tothenew123");
		driver.findElement(By.id("submitbtn")).click();

		// // Java script
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,900)", "");
		} catch (Exception e) {
			//
		}

		// // Tables + dynamic elements
		driver.get("http://toolsqa.com/automation-practice-table/");
		List<WebElement> table = driver.findElements(By
				.xpath(".//*[@id='content']//tr/td"));

		for (WebElement webElement : table) {
			System.out.println(webElement.getText());
		}

		// // Dynamic Elements
		System.out.println(driver.findElement(
				By.xpath("//*[contains(text(), 'Shan')]")).getText());

		// // Handling frames
		try {
			driver.get("http://demo.automationtesting.in/Frames.html");
			driver.findElement(By.xpath(".//*[@type='text']")).sendKeys(
					"fsdfdfdsf");
		} catch (Exception e) {
			driver.switchTo().frame("singleframe");
			driver.findElement(By.xpath(".//*[@type='text']")).sendKeys(
					"fsdfdfdsf");
		}

		// // Handling windows
		driver.get("http://demo.automationtesting.in/Windows.html");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath(".//*[@id='Tabbed']//button")));
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(driver.getCurrentUrl());
			try {
				System.out
						.println(driver
								.findElement(
										By.xpath(".//*[@id='parallax-one']/div/div/div/div/div[1]/div/h5"))
								.getText());

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			try {
				System.out.println(driver.findElement(
						By.xpath(".//*[@id='Tabbed']/a/button")).getText());
			} catch (Exception r) {
				System.out.println(r.toString());
			}
		}
		try {
			driver.switchTo().defaultContent();
			System.out.println(driver.findElement(
					By.xpath(".//*[@id='Tabbed']/a/button")).getText());

		} catch (Exception e) {
			System.out.println(e.toString());

		}

		// // Drag And Drop
		try {
			driver.get("http://demo.guru99.com/test/drag_drop.html");
			Thread.sleep(5000);
			WebElement From = driver.findElement(By
					.xpath("//*[@id='credit2']/a"));
			WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));
			Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
			Thread.sleep(5000);
		} catch (Exception r) {
			System.out.println(r.toString());
		}
	}

}
