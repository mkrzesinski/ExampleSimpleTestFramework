package ui.pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * LoginPage is a page object representing the login page of GitHub. It contains methods to interact
 * with the login page elements.
 */
@Getter
public class LoginPage extends AbstractPage {

  private static final String LOGIN_PAGE_DESCRIPTION = "//*[@id=\"login\"]/div[1]/h1";
  private static final String USER_NAME_OR_EMAIL = "login_field";
  private static final String PASSWORD = "password";
  private static final String SIGN_IN_BUTTON = "commit";
  private static final String INCORRECT_LOGIN_DATA_LABEL = "js-flash-alert";
  private static final String CANCEL_ALERT_BUTTON =
      "//*[@id=\"js-flash-container\"]/div/div/button";

  @FindBy(xpath = LOGIN_PAGE_DESCRIPTION)
  WebElement loginPageDescription;

  @FindBy(id = USER_NAME_OR_EMAIL)
  WebElement userNameField;

  @FindBy(id = PASSWORD)
  WebElement passwordField;

  @FindBy(name = SIGN_IN_BUTTON)
  WebElement signInButton;

  @FindBy(className = INCORRECT_LOGIN_DATA_LABEL)
  WebElement incorrectLoginDataLabel;

  @FindBy(xpath = CANCEL_ALERT_BUTTON)
  WebElement cancelAlertButton;

  /**
   * Constructor for LoginPage.
   *
   * @param webDriver - WebDriver instance used for interacting with the browser.
   */
  public LoginPage(WebDriver webDriver) {
    super(webDriver);
    waitForPageToLoad();
  }

  private void waitForPageToLoad() {
    super.waitForPageToLoad(loginPageDescription, userNameField, passwordField);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(signInButton));
  }

  /** This method clicks the sign-in button on the login page. */
  public void waitUntilElementInvisible(WebElement element) {
    webDriverWait
        .withMessage("Element is still visible")
        .until(ExpectedConditions.invisibilityOf(element));
  }

  /** This method clicks the sign-in button on the login page. */
  public void fillCredencialsWithGivenData(
      @org.jetbrains.annotations.NotNull JavascriptExecutor javascriptExecutor,
      final String userName,
      final String password) {
    javascriptExecutor.executeScript("arguments[0].value=arguments[1];", userNameField, userName);
    javascriptExecutor.executeScript("arguments[0].value=arguments[1];", passwordField, password);
  }
}
