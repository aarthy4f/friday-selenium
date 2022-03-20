package e2e.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * The Class represents VehicleSelectionPage.
 *
 * @author Aarthy
 */

public class VehicleSelectPage {

    private WebDriver driver;
    protected FluentWait<WebDriver> waiter;






        /** The email input. */
        @FindBy(xpath="//button[@name='list']")
        private WebElement choosemodel;

        @FindBy(xpath = "//input[@name='makeFilter']")
        private WebElement cardbrand;


        @FindBy(name = "inceptionDate")
        private WebElement inceptionDate;

        @FindBy(xpath="//button[@type='submit']")
        private WebElement continuebtn;

        @FindBy(xpath="//button[@name='make'][1]")
        private WebElement selectmodel;

    @FindBy(xpath="//button[@name='bodyType'][1]")
    private WebElement bodytype;

    @FindBy(xpath="//button[@name='fuelType'][1]")
    private WebElement fueltype;

    @FindBy(xpath="//button[@name='enginePower'][1]")
    private WebElement enginepower;

    @FindBy(xpath="//button[@name='engine'][1]")
    private WebElement engine;


    public void  clickbodytype() {
        bodytype.click();
    }

    public void  clickfueltype() {
        fueltype.click();
    }

    public void  clickenginepower() {
        enginepower.click();
    }

    public void  clickengine() {
        engine.click();
    }

    public void clickmodeltype(String model){
        String vehcilexpath="//label[text()='"+model+"']/parent::div";
        System.out.println(vehcilexpath);
        WebElement  elm=driver.findElement(By.xpath(vehcilexpath));
        elm.click();

    }

    /**
         * Instantiates a new Vehicleselectpage.
         *
         * @param driver the driver
         */
        public VehicleSelectPage(WebDriver driver) {

            this.driver = driver;
            PageFactory.initElements(driver, this);
            waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
                    .withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30));

        }


        public void  clickchoosemodel() {
                choosemodel.click();
        }

       public void entermodel(String model) {
           cardbrand.clear();
           cardbrand.sendKeys(model);

        }

        public void clickmodel() {
            selectmodel.click();
        }


}
