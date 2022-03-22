package e2e.businessspecific;


import com.relevantcodes.extentreports.LogStatus;
import e2e.pages.InsuranceLoginPage;
import e2e.util.ReportUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class precondition {
    private WebDriver driver;

    public precondition(WebDriver driver) {

        this.driver=driver;

    }
    public void verifypreselection(String insurancestatus) throws Exception {
        try {

            WebElement elm = driver.findElement(By.xpath("//label[contains(@data-testid,'buyingCarquoting')]"));
            InsuranceLoginPage insuranceLoginPage = new InsuranceLoginPage(driver);

            if (insurancestatus.contains("Modify")) {
                ReportUtil.logMessage("Insurance Selection", "Change of Issuer");
                insuranceLoginPage.existingcarselectradio();
                ReportUtil.addScreenShot("Change of Issuer selected");
            } else {
                String selected = insuranceLoginPage.newcarradioInput();
                if (selected.contains("true")) {
                    Assert.assertTrue(true, "Preslected checkbox");
                } else {
                    insuranceLoginPage.newcarselectradio();

                    Assert.assertTrue(true, "Preslected checkbox not checked");

                }
                ReportUtil.logMessage("Insurance Selection", "Purchase or change of owner");
                ReportUtil.addScreenShot("Purchase or change of owner selected");

            }

            String inceptiondate = insuranceLoginPage.getinceptionDate();
            if (inceptiondate.length() != 0) {
                Assert.assertTrue(true, "Date already Selected");
            } else {
                insuranceLoginPage.setinceptionDate();
                Assert.assertTrue(true, "Date is now set");

            }

        } catch (Exception e) {
            ReportUtil.logMessage(LogStatus.FAIL,"TestExecution Failed due to exception",e.getMessage());

        }
    }
}
