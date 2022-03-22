package e2e.pages;

import org.openqa.selenium.*;
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

    /**
     * The model selection
     **/
    @FindBy(xpath = "//button[@name='list']")
    private WebElement choosemodel;

    /**
     * The car brand selection
     **/
    @FindBy(xpath = "//input[@name='makeFilter']")
    private WebElement cardbrand;


    /**
     * The submit button
     **/
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continuebtn;

    @FindBy(xpath = "//button[@name='make'][1]")
    private WebElement selectmodel;

    @FindBy(xpath = "//button[@name='bodyType'][1]")
    private WebElement bodytype;

    @FindBy(xpath = "//button[@name='fuelType'][1]")
    private WebElement fueltype;

    /**
     * The engine brand selection
     **/
    @FindBy(xpath = "//button[@name='enginePower'][1]")
    private WebElement enginepower;
    /**
     * The engine  selection
     **/
    @FindBy(xpath = "//button[@name='engine'][1]")
    private WebElement engine;

    @FindBy(xpath = "//input[@name='monthYearFirstRegistered']")
    private WebElement yearregistered;

    @FindBy(xpath = "//input[@name='monthYearOwnerRegistered']")
    private WebElement ownerregistered;

    @FindBy(xpath = "//input[@name='birthDate']")
    private WebElement birthdate;

    @FindBy(xpath = "//input[@name='monthYear']")
    private WebElement caryear;
    @FindBy(xpath = "//input[@name='hsn']")
    private WebElement carhsn;
    @FindBy(xpath = "//input[@name='tsn']")
    private WebElement cartsn;
    @FindBy(xpath = "//button[@name='hsnTsn']")
    private WebElement findtsn;

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

    /**
     * click body type
     **/
    public void clickbodytype() {
        bodytype.click();
    }

    /**
     * click fuel type
     **/
    public void clickfueltype() {
        fueltype.click();
    }

    /**
     * click enginepower
     */
    public void clickenginepower() {
        enginepower.click();
    }

    /**
     * click engine
     */
    public void clickengine() {
        engine.click();
    }

    /**
     * click the car model value
     */

    public void clickchoosemodel() {
        choosemodel.click();
    }

    /**
     * Enter the car model value
     */
    public void enterbrand(String model) {
        cardbrand.clear();
        cardbrand.sendKeys(model);

    }

    public void clickmodel() {
        selectmodel.click();
    }

    /**
     * Enter the year registered
     */

    public void enteryearregiestered(String year) {
        yearregistered.clear();
        yearregistered.sendKeys(year);

    }

    /**
     * Enter the ownwer registered
     */
    public void enterownerregiestered(String year) {
        ownerregistered.clear();
        ownerregistered.sendKeys(year);

    }

    /**
     * Enter the date of birth
     */

    public void enterbirthdate(String year) {
        birthdate.clear();
        birthdate.sendKeys(year);

    }

    /**
     * get the date of birth
     */

    public String getbirthdate() {
        String date = birthdate.getText();
        return date;

    }

    public void enterCaryear(String year) {
        caryear.clear();
        caryear.sendKeys(year);
    }

    public void enterCarhsn(String year) {
        carhsn.clear();
        carhsn.sendKeys(year);
    }

    public void enterCartsn(String year) {
        cartsn.clear();
        cartsn.sendKeys(year);
    }

    public void clicksubmit() {
        continuebtn.click();
    }

    public void clickhsn() {
        findtsn.click();
    }

}

