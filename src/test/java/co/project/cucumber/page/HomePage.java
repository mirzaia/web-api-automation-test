package co.project.cucumber.page;

import java.time.Duration;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  {
  private static final String usernameFieldXpath = "//input[@id='user-name']";
  private static final String passwordFieldXpath = "//input[@id='password']";
  private static final String submitButtonXpath = "//input[@id='login-button']";
  private static final String searchFieldXpath = "//div[@data-testid='home-page-search']//input";
  private static final String logoXpath = "//img[@data-testid='nv-logo']";
  private static final String dropdownXpath = "//span[@data-key='home_page_try_entering_full_tracking_id']";
  private static final String productXpath = "//div[contains(text(),'Sauce Labs Backpack')]";
  private static final HashMap<String, String> pageForCountry = new HashMap<>();

  static {
    pageForCountry.put("Indonesia", "co-id");
    pageForCountry.put("Singapore", "co-sg");
    pageForCountry.put("Malaysia", "co-my");
    pageForCountry.put("Philliphines", "co-ph");
    pageForCountry.put("Thailand", "co-th");
    pageForCountry.put("Vietnam", "co-vn");
  }

  protected final WebDriver webDriver;

  public HomePage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public void navigateTo(String url) {
    getWebDriver().get(url);
  }

  public void logIntoWebsite(String username, String password) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(usernameFieldXpath)));

    WebElement usernameField = getWebDriver().findElement(By.xpath(usernameFieldXpath));
    for (char c : username.toCharArray()) {
      usernameField.sendKeys(String.valueOf(c));
      try {
        Thread.sleep(100); // 100ms delay between keystrokes
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    WebElement passwordField = getWebDriver().findElement(By.xpath(passwordFieldXpath));
    for (char c : password.toCharArray()) {
      passwordField.sendKeys(String.valueOf(c));
      try {
        Thread.sleep(100); // 100ms delay between keystrokes
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public void qaVerifyHomepage() {
    boolean product = getWebDriver().findElement(By.xpath(productXpath)).isDisplayed();

    Assertions.assertTrue(product);

    if (product) {
      System.out.println("User is on the homepage");
    } else {
      System.out.println("User is not on the homepage");
    }
  }

  public void clickSubmitLoginButton() {
    getWebDriver().findElement(By.xpath(submitButtonXpath)).click();
  }

  public void qaSearchOrderWithTrackingId(String trackingId) {
    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoXpath)));
    WebElement searchField = getWebDriver().findElement(
        By.xpath(searchFieldXpath));
    for (char c : trackingId.toCharArray()) {
      searchField.sendKeys(String.valueOf(c));
      try {
        Thread.sleep(100); // 100ms delay between keystrokes
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    searchField.sendKeys(Keys.RETURN);
  }

  public void qaVerifyIfOrderIsFound(String trackingId) {
    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='order-details-header']")));
    WebElement orderTextOnPage = getWebDriver().findElement(
        By.xpath("//div[@data-testid='order-details-header']/div[2]"));
    Assertions.assertEquals(orderTextOnPage.getText(), trackingId);
  }
}
