package Reporting;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportStatus {
	
	public static void main(String[] args) throws IOException {
		startReporting();
	}
	
	
	public static void  startReporting() throws IOException {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\Selenium Java\\Extent Reports Results\\samplehtml.html");
		reporter.config().setReportName("Build VErification TEst Report");
		reporter.config().setDocumentTitle("Central Run Report");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("URL", "google.com");
		extent.setSystemInfo("Screenshots Location", "Location details");
		
		ExtentTest logReport = extent.createTest("Test Case Name 1");
		
		
		
		logReport.log(Status.INFO, "SAmple Info");
		
		logReport.addScreenCaptureFromPath("D:\\Selenium Java\\Extent Reports Results\\49_Passed.png","Test 1");
		
		logReport.log(Status.PASS, "SAmple Info Pass");
		logReport.log(Status.FAIL, "SAmple Info FAIL");
		logReport.log(Status.WARNING, "SAmple Info Warning");
		extent.flush();
		
		
		
		logReport = extent.createTest("Test Case Name 2");
		logReport.log(Status.INFO, "SAmple Info");
		logReport.log(Status.PASS, "SAmple Info Pass");
		logReport.log(Status.WARNING, "SAmple Info Warning");
		extent.flush();
		
		logReport= extent.createTest("Test Case Name 3");
		logReport.createNode("INternal Step 1 or validation 1");
		logReport.log(Status.INFO, "SAmple Info");
		logReport.log(Status.PASS, "SAmple Info Pass");
		
		 logReport.createNode("INternal Step 2 or validation 2");
		logReport.log(Status.FAIL, "SAmple Info Warning");
		extent.flush();
		
		
		logReport= extent.createTest("Test Case Name 4");
		
		 logReport.createNode("INternal Step 1 or validation 1");
		logReport.log(Status.INFO, "SAmple Info");
		logReport.log(Status.PASS, "SAmple Info Pass");
		
		 logReport.createNode( "INternal Step 2 or validation 2");
		logReport.log(Status.PASS, "SAmple Info PASS");
		extent.flush();
		
		
	}
	
	
}
