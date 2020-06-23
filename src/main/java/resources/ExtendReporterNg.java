package resources;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtendReporterNg {
	static ExtentReports extent;

	public static ExtentReports getReportObjects() {
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		extent=new ExtentReports(path);
		return extent;
		
	}

}
