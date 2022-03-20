package e2e.pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * The Class represents InsuranceLoginPage.
 *
 * @author Aarthy
 */

public class InsuranceLoginPage {
    private WebDriver driver;
    protected FluentWait<WebDriver> waiter;


        /** The buying new card insurance  */

        @FindBy(xpath = "//label[contains(@data-testid,'buyingCarquoting')]")
        private WebElement newcarradio;

        /** The Inceptiondate. */
        @FindBy(name = "inceptionDate")
        private WebElement inceptionDate;

        /** The submit button. */
        @FindBy(xpath="//button[@type='submit']")
        private WebElement continuebtn;
        /**
         * Instantiates a new Insurancelogin page.
         *
         * @param driver the driver
         */
        public InsuranceLoginPage(WebDriver driver) {

            this.driver = driver;
           PageFactory.initElements(driver, this);
            waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
                    .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
        }
    /**
     * Verify the new car insurance radio button selected
     * */

        public String  newcarradioInput() {
            String attribute= newcarradio.getAttribute("data-checked");
            if(attribute==null){
                return "false";

            }
            return attribute;
        }
        /**
         * Select the new car insurance radio button
         * */

        public void newcarselectradio() {
            newcarradio.click();
        }

    /**
     * Verify the inceptiondate is entered*
     * */
        
       public String getinceptionDate() {
             String datevalue= inceptionDate.getAttribute("value");
             return datevalue;

        }
    /**
     * set the inceptiondate *
     * */
    public void setinceptionDate() {
        inceptionDate.sendKeys("22.03.2022");

    }
    /**
     * Click the submit
     * */

    public void clicksubmit() {
                continuebtn.click();
        }

        /**
         * Click sign in.
         */
      /*  public void clickSignIn() {
            pass.submit();
        }*/
    //}
//
}
