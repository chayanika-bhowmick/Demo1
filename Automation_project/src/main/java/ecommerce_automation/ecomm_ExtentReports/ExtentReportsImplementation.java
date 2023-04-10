package ecommerce_automation.ecomm_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsImplementation {

	public String path = System.getProperty("user.dir")+"//HtmlReports//report.html";
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	//extent.attachReporter(reporter);
	
	
}
