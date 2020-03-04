package baseClass.base;

import org.json.JSONObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.FilesManager;
import utils.GlobalVariables;

import java.io.IOException;
import java.net.URL;

public class DriversInitialization {

    private WebDriver driver;
    private WebDriverWait wait;
    private String geckoDriver = "";
    private String chromeDriver = "";
    protected SoftAssert softAssert;
    private String browser = "";

    public WebDriver getCurrentDriver(){
        return  driver;
    }

    public WebDriverWait getCurrentWait(){
        return  wait;
    }

    protected void initDriver(String runOn, String browser) {
        try {
            selectDriverBasedOnOs();
            if (runOn.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", geckoDriver);

                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else {
                if (runOn.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", chromeDriver);
                    DesiredCapabilities caps = DesiredCapabilities.chrome();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(new String[]{"--start-maximized"});
                    options.merge(caps);
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                } else if (runOn.equals("ie")) {
                    System.setProperty("webdriver.ie.driver", "drivers/windows/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                } else if (runOn.equals("safari")) {
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                }else if (runOn.equalsIgnoreCase("grid")){
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getCapabilities(browser));
                }
            }
            wait = new WebDriverWait(driver, 35, 100);
            softAssert =  new SoftAssert();
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("fail to init the browser " + ex.getMessage());
        }
    }

    private DesiredCapabilities getCapabilities(String browser){
        DesiredCapabilities capabillities = new DesiredCapabilities();
        String browserConfContent = "";
        try {
            browserConfContent = FilesManager.readFile(System.getProperty("user.dir") + "/src/main/resources/browsersConfig.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        GlobalVariables.browsersConfigurations = new JSONObject(browserConfContent);
        if (GlobalVariables.browsersConfigurations.has(browser)) {
            JSONObject configuration = GlobalVariables.browsersConfigurations.getJSONObject(browser);
            if (browser.contains("firefox")){
                capabillities =  DesiredCapabilities.firefox();
                capabillities.setPlatform(Platform.LINUX);
                capabillities.setVersion(configuration.getString("version"));
                capabillities.setBrowserName(configuration.getString("browserName"));
            }else if (browser.contains("chrome")){
                capabillities =  DesiredCapabilities.chrome();
                capabillities.setPlatform(Platform.LINUX);
                capabillities.setVersion(configuration.getString("version"));
                capabillities.setBrowserName(configuration.getString("browserName"));
            }
        }
        return capabillities;
    }


    private void selectDriverBasedOnOs(){
        String operativeSystem = System.getProperty("os.name").toLowerCase();
        if(operativeSystem.contains("mac")){
            geckoDriver = "drivers/macOsx/geckodriver";
            chromeDriver = "drivers/macOsx/chromedriver";
        }else if(operativeSystem.contains("windows")){
            geckoDriver = "drivers/windows/geckodriver.exe";
            chromeDriver = "drivers/windows/chromedriver.exe";
        }
    }
}
