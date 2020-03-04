package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private WebDriverWait wait;

    public Waits(WebDriverWait wait){
        this.wait = wait;
    }

    public WebElement waitUntilVisibilityOfElement(WebElement element){
        try{
            element = wait.until(ExpectedConditions.visibilityOf(element));
            return  element;
        }catch (Exception e){
            return null;
        }
    }

    public WebElement waitElementToBeClickable(WebElement element){
        try{
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            return  element;
        }catch (Exception e){
            return null;
        }
    }
}
