package e2e.tests;

import java.time.Duration;

import e2e.util.ExcelUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;

import org.testng.annotations.*;

import e2e.context.WebDriverContext;
import e2e.listeners.LogListener;
import e2e.listeners.ReportListener;
import e2e.util.LoggerUtil;
import e2e.util.MailUtil;
import e2e.util.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Every test class should extend this class.
 *
 * @author Aarthy
 */
@Listeners({ReportListener.class, LogListener.class})
public class BaseTest {

    /**
     * The driver.
     */
    public WebDriver driver;


    /**
     * Global setup.
     */
    @BeforeSuite(alwaysRun = true)
    public void globalSetup() {
        LoggerUtil.log("************************** Test Execution Started ************************************");
        TestProperties.loadAllPropertie();
    }

    /**
     * Wrap all up.
     *
     * @param context the context
     */
    @AfterSuite(alwaysRun = true)
    public void wrapAllUp(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        LoggerUtil.log("Total number of testcases : " + total);
        LoggerUtil.log("Number of testcases Passed : " + passed);
        LoggerUtil.log("Number of testcases Failed : " + failed);
        LoggerUtil.log("Number of testcases Skipped  : " + skipped);
        boolean mailSent = MailUtil.sendMail(total, passed, failed, skipped);
        LoggerUtil.log("Mail sent : " + mailSent);
        LoggerUtil.log("************************** Test Execution Finished ************************************");
    }

    /**
     * Setup.
     */
    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // options = new ChromeOptions();
            options.addArguments("enable-automation");
            //options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            //ops.addArguments("--lang=en");

            driver = new ChromeDriver();


        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        //WebDriverContext WebDriverContext= new WebDriverContext();
        WebDriverContext.setDriver(driver);
        driver.get("https://hello.friday.de/quote/selectPrecondition");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(4));
        WebElement root1 = driver.findElement(By.id("usercentrics-root"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        SearchContext shadowRoot1 = (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot", root1);
        shadowRoot1.findElement(By.cssSelector("button[data-testid=uc-accept-all-button]")).click();


    }

    @BeforeMethod
    public void launchapplication() {
        driver.get("https://hello.friday.de/quote/selectPrecondition");

    }

    @DataProvider(name = "cardetails", parallel = false)

    public static Object[][] cardetails() throws Exception {

        // The number of times data is repeated, test will be executed the same no. of times

        Object[][] testObjArray = ExcelUtil.getTableArray();


        return (testObjArray);


    }



    /**
     * Wrap up.
     */
    @AfterClass
    public void wrapUp() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
