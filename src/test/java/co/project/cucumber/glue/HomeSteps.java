package co.project.cucumber.glue;

import co.project.cucumber.page.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeSteps {
  private static HomePage homepage;
  private static WebDriver driver;

  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    homepage = new HomePage(driver);
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  };

  public HomeSteps() {
  }

  @When("QA go to website {string}")
  public void qaGoToWebsite(String url) {
    homepage.navigateTo(url);
  }

  @And("QA input username {string} and password {string}")
  public void qaInputUsernameAndPassword(String username, String password)
      throws InterruptedException {
    homepage.logIntoWebsite(username, password);
  }

  @And("QA verify if user arrived at homepage")
  public void qaVerifyArrivedHomepage() {
    homepage.qaVerifyHomepage();
  }

  @And("QA verify that error message {string} is displayed")
  public void qaVerifyErroDialog(String errorMsg) {
    homepage.qaVerifyErrorMessage(errorMsg);
  }

  @And("QA click Submit button on the login page")
  public void qaClickSubmitButton() {
    homepage.clickSubmitLoginButton();
  }

  @And("QA click close error button on the login page")
  public void qaClickCloseErrorButton() {
    homepage.clickCloseErrorButton();
  }

  @And("QA verify that component with data-test {string} is NOT displayed on the page")
  public void qaVerifyComponentIsNotDisplayed(String dataTest) {
    homepage.qaVerifyComponentIsNotDisplayed(dataTest);
  }

  @And("QA search order with tracking ID {string} and make sure that the order is found")
  public void qaSearchOrderAndVerifyIfDisplayed(String trackingId) {
    homepage.qaSearchOrderWithTrackingId(trackingId);
    homepage.qaVerifyIfOrderIsFound(trackingId);
  }
}