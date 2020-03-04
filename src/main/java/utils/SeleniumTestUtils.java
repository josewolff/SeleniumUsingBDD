package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestUtils {

    public static void waitForPageLoad(final WebDriver driver){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver wdriver) {
                    return ((JavascriptExecutor) driver).executeScript(
                            "return document.readyState"
                    ).equals("complete");
                }
            });		}catch(Exception e){
        }
    }

    public static void highlight(WebDriver driver, WebElement element) throws InterruptedException{
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        Thread.sleep(500);
    }


    public static void clickElementJs(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
