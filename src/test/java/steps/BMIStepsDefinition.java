package steps;

import baseClass.Drivers;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.actions.BMITrackerActions;
import utils.SeleniumTestUtils;

public class BMIStepsDefinition extends Drivers {

    private WebDriver driver;
    private WebDriverWait wait;
    private BMITrackerActions bmiTrackerActions;

    @Given("^is using the running the test in \"([^\"]*)\" using the browser \"([^\"]*)\"$")
    public void isUsingTheRunningTheTestInRunOnUsintTheBrowserBrowser(String runOn, String browser) {
        startDriver(runOn, browser);
    }

    @And("^the user navigates to \"([^\"]*)\"$")
    public void theUserNavigatesToUrl(String url) {
        driver = getDriver();
        wait = getCurrentWait();
        driver.get(url);
        bmiTrackerActions = new BMITrackerActions(driver,wait, softAssert);
        SeleniumTestUtils.waitForPageLoad(driver);
    }

    @And("^writes the weight (\\d+)$")
    public void writesTheWeight(int weight) throws InterruptedException {
        System.out.println(weight);
        bmiTrackerActions.sendKeyWeight(weight);
    }

    @And("^writes the height (\\d+)$")
    public void writesTheHeightHeight(int height) throws InterruptedException {
        bmiTrackerActions.sendKeyHeight(height);
    }

    @When("^click the calculate BMI button$")
    public void clickTheCalculateBMIButton() throws InterruptedException {
        bmiTrackerActions.clickCalculateBMIButton();
    }

    @Then("^the BMI result should be (.+)$")
    public void theBMIResultShouldBeExpectedResult(double expectedResult) throws InterruptedException {
        double result = bmiTrackerActions.getBMIResult();
        if(result != expectedResult){
            softAssert.fail("Result is not the expected. Expected: " + expectedResult + "\nCurrent Result: " + result);
        }
        closeDriver();
        softAssert.assertAll();
    }
}
