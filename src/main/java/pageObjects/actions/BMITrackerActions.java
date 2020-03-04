package pageObjects.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.BMITrackerElements;
import utils.SeleniumTestUtils;
import utils.Waits;

public class BMITrackerActions extends BMITrackerElements {

    private Waits waits;
    private SoftAssert softAssert;
    WebDriver driver;
    public BMITrackerActions(WebDriver driver, WebDriverWait wait, SoftAssert softAssert) {
        super(driver);
        this.driver = driver;
        waits = new Waits(wait);
        this.softAssert = softAssert;
    }

    public void sendKeyWeight(int weight) throws InterruptedException {
        weightElement = waits.waitUntilVisibilityOfElement(weightElement);
        if (weightElement != null) {
            SeleniumTestUtils.highlight(driver,weightElement);
            weightElement.sendKeys(String.valueOf(weight));
        }else{
            softAssert.fail("The weightElement input is not visible on the page.");
        }

    }

    public void sendKeyHeight(int height) throws InterruptedException {
        heightElement = waits.waitUntilVisibilityOfElement(heightElement);
        if (heightElement != null) {
            SeleniumTestUtils.highlight(driver,heightElement);
            heightElement.sendKeys(String.valueOf(height));
        }else{
            softAssert.fail("The heightElement input is not visible on the page.");
        }

    }

    public void clickCalculateBMIButton() throws InterruptedException {
        calculateBmi = waits.waitElementToBeClickable(calculateBmi);
        if (calculateBmi != null) {
            SeleniumTestUtils.highlight(driver,calculateBmi);
            calculateBmi.click();
        }else{
            softAssert.fail("The calculateBmi button is not clickable on the page.");
        }
    }

    public double getBMIResult() throws InterruptedException {
        bmiResult = waits.waitUntilVisibilityOfElement(bmiResult);
        if (bmiResult != null) {
            SeleniumTestUtils.highlight(driver,bmiResult);
            String result = bmiResult.getText();
            String onlyValue =  result.substring(result.indexOf(":")+1).trim();
            System.out.println("Application BMI Result: " + onlyValue);
            return Double.parseDouble(onlyValue);
        }else{
            softAssert.fail("The bmiResult input is not visible on the page.");
        }
        return -1;
    }


}
