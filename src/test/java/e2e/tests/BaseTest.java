package e2e.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import e2e.util.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.DataProvider;

import e2e.context.WebDriverContext;
import e2e.listeners.LogListener;
import e2e.listeners.ReportListener;
import e2e.util.LoggerUtil;
import e2e.util.MailUtil;
import e2e.util.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Every test class should extend this calss.
 *
 * @author Bharathish
 */
@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

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
	@BeforeClass
	protected void setup() {
//		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		//ops.addArguments("--lang=en");

		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> langs = new HashMap<String, Object>();
		langs.put("de", "en");
		prefs.put("translate", "{'enabled' : true}");
		prefs.put("translate_whitelists", langs);
		ops.setExperimentalOption("prefs", prefs);
		//ops.setExperimentalOption()'prefs', {'intl.accept_languages': 'en,en_US'})
		//ops.addArguments("--lang= locale-of-choice");
		//ops.addArguments("disable-infobars");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("Cookie name");

		//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		WebDriverContext.setDriver(driver);
		driver.get("https://hello.friday.de/quote/selectPrecondition");
	}
	@DataProvider(name = "cardetails")

	public static Object[][] cardetails() throws Exception{

	 // The number of times data is repeated, test will be executed the same no. of times

	 // Here it will execute two times
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
