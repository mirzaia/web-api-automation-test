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
  public void qaVerifyArrivedHomepahe() {
    homepage.qaVerifyHomepage();
  }

  @And("QA click Submit button on the login page")
  public void qaClickSubmitButton() {
    homepage.clickSubmitLoginButton();
  }

  @And("QA search order with tracking ID {string} and make sure that the order is found")
  public void qaSearchOrderAndVerifyIfDisplayed(String trackingId) {
    homepage.qaSearchOrderWithTrackingId(trackingId);
    homepage.qaVerifyIfOrderIsFound(trackingId);
  }
}