package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends PageObject {

    @FindBy(css = "#lst-ib")
    private WebElement searchBox;

    @FindBy(css = "#sbtc > div.gstl_0.sbdd_a > div:nth-child(2) > div.sbdd_b > div > ul > li:nth-child(11) > div > span:nth-child(1) > span > input")
    private WebElement searchButton;

    @FindBy(css = "#sbtc > div.gstl_0.sbdd_a > div:nth-child(2) > div.sbdd_b > div > ul > li:nth-child(11) > div > span:nth-child(2) > span > input")
    private WebElement luckyButton;

    public GooglePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public GooglePage open() {
        driver.get("http://www.google.es");
        return this;
    }

    public GooglePage writeSearch(String search) {
        searchBox.sendKeys(search);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE);
        return this;
    }

    public GooglePage clickSearch() {
        searchButton.click();
        return this;
    }

    public GooglePage clickLucky() {
        luckyButton.click();
        return this;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void close() {
        driver.quit();
    }

}
