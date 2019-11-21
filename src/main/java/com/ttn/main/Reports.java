package com.ttn.main;

import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

//// Class to Generate Custom Reports
public class Reports {

	//// Constructor to Initialize Reports
	public Reports()
	{
		Variables.htmlStringBuilder=new StringBuilder();
		Variables.htmlStringBuilder.append("<html><head><title>Automation Status</title></head>");
		Variables.htmlStringBuilder.append("<body>");
		Variables.htmlStringBuilder.append("<H1><center> Automation Status");
		Variables.htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\" style=\"width:100%\">");
		Variables.htmlStringBuilder.append("<tr align=\"center\" bgcolor=\"#25419F\"><td><b>TC_Id</b></td><td><b>TEST_CASE</b></td><td><b>TEST_STEP</b></td><td><b>Result</b></td></tr>");

	}
	
	//// Generic Function for generating reports
	public void GenerateReport(String TC_Id,String TEST_CASE , String TEST_STEP ,String testResult)
	{
		if(testResult.equalsIgnoreCase("true")){
			String Result = "pass";
			String appenedData = "<tr align=\"center\"><td>"+TC_Id+"</td><td>"+TEST_CASE+"</td><td>"+TEST_STEP+"</td><td bgcolor=\"#008000\">"+Result+"</td></tr>";
			Variables.htmlStringBuilder.append(appenedData);
			}
			else{
				
				try {
					String Result = "false";
					String errorPath = "D:\\Project\\POM\\Reports\\" + TEST_STEP + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".png";
					 Robot robot;
					robot = new Robot();
					BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
					ImageIO.write(screenShot, "JPG", new File(errorPath));
					String appenedData = "<tr align=\"center\"><td>"+TC_Id+"</td><td>"+TEST_CASE+"</td><td>"+TEST_STEP+"</td><td bgcolor=\"#FF0000\"><a href=\""+errorPath +"\">"+Result+"</td></tr></a>";
					Variables.htmlStringBuilder.append(appenedData);
				} catch (Exception e) {
					String appenedData = "<tr align=\"center\"><td>"+TC_Id+"</td><td>"+TEST_CASE+"</td><td>"+TEST_STEP+"</td><td bgcolor=\"#FF0000\">"+testResult+"</td></tr>";
					Variables.htmlStringBuilder.append(appenedData);
					
				} 				
				     
				
			}
	}
	
	//// Function to save reports
	public void Destruct()
	{
		Variables.htmlStringBuilder.append("</body>");
		Variables.htmlStringBuilder.append("</html>");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String sheetPath = "D:\\Project\\POM\\Reports\\" + timeStamp + ".html";
		File f = new File(sheetPath);
		try {
			FileWriter fwriter = new FileWriter(f);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write(Variables.htmlStringBuilder.toString());
			bwriter.close();
			try {
				 Desktop desktop = Desktop.getDesktop();
				 File file = new File(sheetPath);
				 desktop.open(file);
		    } catch (IOException e) {
		    	e.getCause().printStackTrace();
		        e.printStackTrace();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
