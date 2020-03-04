package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by josea.wolff on 6/22/19.
 */
public class TakeScreenShots {

    private WebDriver driver;

    public TakeScreenShots(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenShot(String fileName){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/" + fileName));
        } catch (IOException e) {
            System.out.println("################ fail: TakeScreenShots.takeScreenShot #######################");
            e.printStackTrace();
        }
    }
}
