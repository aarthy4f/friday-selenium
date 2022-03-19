package e2e.tests;

import com.relevantcodes.extentreports.ExtentTest;
import e2e.businessspecific.vehicleselection;
import e2e.pages.insuranceLoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;


public class InsuranceTest extends BaseTest {
    static ExtentTest test;

    @Test(dataProvider = "cardetails",testName = "Purchase insurance for car")
    public void InsuranceTest(String car, String model, String type) {
        System.out.println(car);
        System.out.println(model);
        System.out.println(type);




        insuranceLoginPage insuranceLoginPage=new insuranceLoginPage(driver);


       insuranceLoginPage.clicksubmit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
       insuranceLoginPage.clicksubmit();
       vehicleselection vehicle=new vehicleselection(driver);
       vehicle.selectmodel(car,model,type);
       WebElement elm=driver.findElement(By.xpath(("//input[@name='monthYearFirstRegistered']")));
       elm.sendKeys("11.1989");




       Assert.assertTrue(elm.getText()!=null, "Test Execution success");
    }


}
