package e2e.tests;

import com.relevantcodes.extentreports.ExtentTest;
import e2e.businessspecific.vehicleselection;
import e2e.pages.insuranceLoginPage;
import e2e.pages.VehicleSelectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InsuranceTest extends BaseTest {
    static ExtentTest test;

    @Test(dataProvider = "cardetails")
    public void InsuranceTest(String car, String model, String type) {
        System.out.println(car);
        System.out.println(model);
        System.out.println(type);


        insuranceLoginPage insuranceLoginPage=new insuranceLoginPage(driver);


       insuranceLoginPage.clicksubmit();
       insuranceLoginPage.clicksubmit();
       vehicleselection vehicle=new vehicleselection(driver);
       vehicle.selectmodel(car,model,type);
       WebElement elm=driver.findElement(By.xpath(("//input[@name='monthYearFirstRegistered']")));
       elm.sendKeys("11.1989");

      /* VehicleSelectPage vehicleSelectPage=new VehicleSelectPage(driver);
        vehicleSelectPage.clickchoosemodel();
        vehicleSelectPage.entermodel(model);
        vehicleSelectPage.clickmodeltype(model);*/
     //

     /*
        vehicleSelectPage.clickmodel();
        String dynamicmodel="//div[contains(@class,'groupTitle')]/following::button[1]";
       WebElement elm;
       elm=driver.findElement(By.xpath(dynamicmodel));
       elm.click();
        Assert.assertTrue(true, "select Vehcile");


        WebElement executeshadow = shadowRoot1.findElement(By.cssSelector("button[data-testid=uc-accept-all-button]"));
        executeshadow.click();

        //
             //   (By.xpath("//button[contains(@data-testid,'uc-accept-all-button')]")).click();

        vehicleSelectPage.clickbodytype();
        vehicleSelectPage.clickfueltype();
        vehicleSelectPage.clickenginepower();
        vehicleSelectPage.clickengine();

     /*  elm= driver.findElement(By.xpath("//button[@name='bodyType'][1]"));

       elm.click();


        elm= driver.findElement(By.xpath("//button[@name='fuelType'][1]"));
        elm.click();
        elm=driver.findElement(By.xpath("//button[@name='enginePower'][1]"));
        elm.click();
        elm= driver.findElement(By.xpath(" //button[@name='engine'][1]"));
        elm.click();*/




       Assert.assertTrue(false, "Login failed : Test failed");
    }


}
