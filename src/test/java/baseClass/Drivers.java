package baseClass;
import baseClass.base.DriversInitialization;
import org.openqa.selenium.WebDriver;

/**
 * Created by josea.wolff on 3/1/2020.
 */
public class Drivers extends DriversInitialization {

    public WebDriver getDriver(){
        return getCurrentDriver();
    }


    protected void startDriver(String runOn, String browser){
        System.out.println("\t\tOPENING BROWSER - \n" + runOn);
        initDriver(runOn,browser);
    }


    protected void closeDriver(){
        try {
            getDriver().quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("\t\tCLOSING Browser\n");
    }
}
