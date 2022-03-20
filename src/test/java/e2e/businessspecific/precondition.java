package e2e.businessspecific;


import e2e.pages.InsuranceLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class precondition {
    private WebDriver driver;

    public precondition(WebDriver driver) {

        this.driver=driver;

    }
    public void verifypreselection(){
        WebElement elm= driver.findElement(By.xpath("//label[contains(@data-testid,'buyingCarquoting')]"));
        InsuranceLoginPage insuranceLoginPage=new InsuranceLoginPage(driver);

        String selected=insuranceLoginPage.newcarradioInput();
        if(selected.contains("true")){
            Assert.assertTrue(true, "Preslected checkbox");
        }else{
            insuranceLoginPage.newcarselectradio();

            Assert.assertTrue(false, "Preslected checkbox not checked");

        }
        String inceptiondate=insuranceLoginPage.getinceptionDate();
        if(inceptiondate.length()!=0){
            Assert.assertTrue(true, "Date already Selected");
        }else{
            insuranceLoginPage.setinceptionDate();
            Assert.assertTrue(true, "Date is now set");

        }

    }
{}}
