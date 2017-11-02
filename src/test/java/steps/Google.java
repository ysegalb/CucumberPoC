package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.Hook;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class Google extends Hook{

    private GooglePage googlePage;

    public Google(GooglePage googlePage) {
        this.googlePage = googlePage;
        this.driver = googlePage.getDriver();
    }

    @Given("^the home page of google$")
    public void navigateToGoogle() {
        googlePage.open();
    }

    @When("^the user searches (SOMETHING)$")
    public void searchSomething(String search) {
        googlePage.writeSearch(search);
    }

    @And("^wants full results$")
    public void wantsFullResults() {
        googlePage.clickSearch();
    }

    @And("^feels lucky$")
    public void userFeelsLucky() {
        googlePage.clickLucky();
    }

    @Then("^the user is redirected to the first result$")
    public void getFirstResultPage() {
        Assert.assertThat("Titles doesn't match!", googlePage.getTitle(), is(not("SOMETHING - Buscar con Google")));
        googlePage.close();
    }

    @Then("^the user is redirected to the results page$")
    public void theUserIsRedirectedToTheResultsPage() throws Throwable {
        Assert.assertThat("Titles doesn't match!", googlePage.getTitle(), is("SOMETHING - Buscar con Google"));
    }

    @After
    public void killBrowser(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
//        this.driver.close();
//        this.driver.quit();
    }
}
