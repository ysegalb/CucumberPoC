package steps;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    public PageObject() {
        System.setProperty("webdriver.chrome.driver","D:\\Development\\WebDrivers\\chromedriver.exe");
        this.driver =  new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void photo(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
