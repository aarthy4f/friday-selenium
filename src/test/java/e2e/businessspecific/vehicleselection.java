package e2e.businessspecific;
import e2e.pages.VehicleSelectPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class vehicleselection {

    private WebDriver driver;

    public vehicleselection(WebDriver driver) {

        this.driver=driver;
        VehicleSelectPage vehicleSelectPage=new VehicleSelectPage(driver);

    }




    public void selectmodel(String car,String brand,String type){
        VehicleSelectPage vehicleSelectPage=new VehicleSelectPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='list']")));
        
        vehicleSelectPage.clickchoosemodel();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='makeFilter']")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        vehicleSelectPage.entermodel(car);
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
    public void click(String value){
        String xpathvalue="//label[text()='"+value+"']/parent::div";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathvalue)));

        WebElement elm=driver.findElement(By.xpath(xpathvalue));

        elm.click();

    }
    public String returnxpath(String value){
        String xpathvalue="//label[text()='"+value+"']/parent::div";
    return xpathvalue;

    }
}
