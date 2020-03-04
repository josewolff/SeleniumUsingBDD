package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BMITrackerElements {

    @FindBy(id = "weight")
    protected WebElement weightElement;

    @FindBy(id = "height")
    protected WebElement heightElement;

    @FindBy(id = "bmi-btn")
    protected WebElement calculateBmi;

    @FindBy(className = "card-title")
    protected WebElement bmiResult;

    @FindBy(xpath = "//button[contains(text(),'Undo')]")
    protected WebElement undoButton;

    @FindBy(className = "delete-btn")
    protected  WebElement deleteCard;

    private WebDriver driver;

    public BMITrackerElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
