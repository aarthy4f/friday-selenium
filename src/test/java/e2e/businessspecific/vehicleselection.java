package e2e.businessspecific;
import e2e.pages.VehicleSelectPage;
import org.openqa.selenium.*;

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
        vehicleSelectPage.clickchoosemodel();
        vehicleSelectPage.entermodel(car);
        WebElement elm=driver.findElement(By.xpath((returnxpath(car))));
        elm.click();
        //  String vehiclexpath="//label[text()='"+car+"']/parent::div";
        //  String brandxpath="//label[text()='"+brand+"']/ancestor::button";
        //String typexpath="//label[text()='"+type+"']/ancestor::button";
        List<WebElement> listelm=driver.findElements(By.xpath(returnxpath(brand)));
        listelm.get(0).click();

        WebElement root1 = driver.findElement(By.id("usercentrics-root"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        SearchContext shadowRoot1 = (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot", root1);
        shadowRoot1.findElement(By.cssSelector("button[data-testid=uc-accept-all-button]")).click();

        elm=driver.findElement(By.xpath(returnxpath(type)));
        elm.click();
        String fuel="Diesel";
        elm=driver.findElement(By.xpath(returnxpath(fuel)));
        elm.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

         vehicleSelectPage.clickenginepower();
        vehicleSelectPage.clickengine();



    }
    public String returnxpath(String value){
        String xpathvalue="//label[text()='"+value+"']/parent::div";
        return xpathvalue;
    }
}
