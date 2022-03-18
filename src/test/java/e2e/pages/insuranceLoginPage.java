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
 * The Class represents FacebookLoginPage.
 *
 * @author Aarthy
 */

public class insuranceLoginPage  {
    private WebDriver driver;
    protected FluentWait<WebDriver> waiter;


        /** The email input. */
        @FindBy(id="radio-2")
        private WebElement buyingcarradio;



        @FindBy(xpath = "//input[@value='keepingCar']")
        private WebElement keepingcarradio;

        /** The pass. */
        @FindBy(name = "inceptionDate")
        private WebElement inceptionDate;

        @FindBy(xpath="//button[@type='submit']")
        private WebElement continuebtn;
        /**
         * Instantiates a new facebook login page.
         *
         * @param driver the driver
         */
        public insuranceLoginPage(WebDriver driver) {

            this.driver = driver;
            PageFactory.initElements(driver, this);
            waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
                    .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
        }


        public void  existingcarradioInput() {
                keepingcarradio.click();
        }
        /**
         * Enter email.
         *
         * @param email the email
         * @return the facebook login page
         */
        public void  buyingcarradioInput() {
            buyingcarradio.click();
        }


        /**
         * Enter password.
         *
         * @param password the password
         * @return the facebook login page
         */
       public void enterinceptiondate(String date) {
               inceptionDate.sendKeys(date);

        }

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
