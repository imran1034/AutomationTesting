package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;

    public static ExtentReports getInstance() {
        if (extent == null) {
            htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void flushReport() {
        extent.flush();
    }
}
