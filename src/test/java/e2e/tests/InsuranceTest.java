package e2e.tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import e2e.businessspecific.precondition;
import e2e.businessspecific.vehicleselection;
import e2e.context.WebDriverContext;
import e2e.pages.InsuranceLoginPage;

import e2e.pages.VehicleSelectPage;
import e2e.report.ExtentReportManager;
import e2e.util.ReportUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;


public class InsuranceTest extends BaseTest {
    static ExtentTest test;



    @Test(dataProvider = "cardetails", testName = "Purchase insurance for car")
    public void InsuranceTest(String insurancestatus, String car, String model, String type, String hsn) throws Exception {
        ReportUtil.logMessage("Test case Details", "Adding the insurance for the car:" + car + " model:+" + model);

        ReportUtil.addScreenShot(LogStatus.INFO, "Default selection");
        System.out.println(car);
        System.out.println(model);
        System.out.println(type);
        System.out.println(insurancestatus);
        System.out.println(hsn);


        InsuranceLoginPage insuranceLoginPage = new InsuranceLoginPage(driver);
        precondition precondition = new precondition(driver);
        precondition.verifypreselection(insurancestatus);
        insuranceLoginPage.clicksubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        insuranceLoginPage.clicksubmit();
        VehicleSelectPage vehicleobj = new VehicleSelectPage(driver);
        vehicleselection vehicle = new vehicleselection(driver);
        if (hsn.contains("null")) {

            vehicle.selectmodel(car, model, type);

            vehicle.registration(insurancestatus);
        } else {

            vehicle.selecthsn(hsn);
        }
        String date = vehicleobj.getbirthdate();



        Assert.assertTrue(date != null, "Test Execution success");
    }


}
