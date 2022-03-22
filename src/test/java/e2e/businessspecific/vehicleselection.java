package e2e.businessspecific;
import e2e.pages.VehicleSelectPage;
import e2e.util.ReportUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class vehicleselection {

    private WebDriver driver;

    public vehicleselection(WebDriver driver) {

        this.driver=driver;

    }

    /**
     * This function is for handling the registration related details during teh insurance flow
     * @param insurancestatus
     */
 public void registration(String insurancestatus){


     VehicleSelectPage vehicleSelectPage=new VehicleSelectPage(driver);
     vehicleSelectPage.enteryearregiestered("02.2005");
        if(insurancestatus.contains("Modify")) {
            vehicleSelectPage.enterownerregiestered("02.2010");
        }
//        vehicleSelectPage.enterownerregiestered("02.2010");
     vehicleSelectPage.clicksubmit();
     vehicleSelectPage.enterbirthdate("11.11.1995");
     ReportUtil.logMessage("Entering the Registration Details","Registration details entered successfully");

 }

    /**
     * This function is to select the car to be insured by providing the HSN/TSN details
     * @param hsn
     */
 public void selecthsn(String hsn){
     ReportUtil.logMessage("Find via the HSN/TNS Finder","HSN Details:"+hsn);

     VehicleSelectPage vehicleSelectPage=new VehicleSelectPage(driver);
     String[] cardetails=hsn.split(":");
     vehicleSelectPage.clickhsn();

     vehicleSelectPage.enterCaryear(cardetails[0]);
     vehicleSelectPage.enterCarhsn(cardetails[1]);
     vehicleSelectPage.enterCartsn(cardetails[2]);
     vehicleSelectPage.clicksubmit();
     driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
     vehicleSelectPage.clicksubmit();
     vehicleSelectPage.enterbirthdate("11.11.1995");



 }

    /**
     * This function is used the select the car based on the brand,model details
     * @param car
     * @param brand
     * @param type
     */
    public void selectmodel(String car,String brand,String type){
        ReportUtil.logMessage("Find by make and model combination","car Details:"+car+" brand:"+brand);

        VehicleSelectPage vehicleSelectPage=new VehicleSelectPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='list']")));
        
        vehicleSelectPage.clickchoosemodel();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='makeFilter']")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        vehicleSelectPage.enterbrand(car);
        click(car);

        List<WebElement> listelm=driver.findElements(By.xpath(returnxpath(brand)));
        listelm.get(0).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(4));


     if(!type.contains("null")){
      click(type);
     }
        String fuel="Diesel";
        click(fuel);
        vehicleSelectPage.clickenginepower();
        vehicleSelectPage.clickengine();

    }

    /**
     * The Xpath is created dynamically using the value parameteer and the click operation performed
     * @param value
     */
    public void click(String value){
        String xpathvalue="//label[text()='"+value+"']/parent::div";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));

        WebElement elm=driver.findElement(By.xpath(xpathvalue));

        elm.click();

    }

    /**
     * Create the dynamic xpath.
     * @param value
     * @return String
     */
    public String returnxpath(String value){
        String xpathvalue="//label[text()='"+value+"']/parent::div";
    return xpathvalue;

    }
}
