package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * GitHubMainPage is a page object representing the main page of GitHub. It contains methods to
 * interact with the main page elements.
 */
public class GitHubMainPage extends AbstractPage {

  private static final String SIGN_IN_BUTTON =
      "/html/body/div[1]/div[3]/header/div/div[2]/div/div/div/a";
  private static final String SIGN_UP_BUTTON =
      "/html/body/div[1]/div[3]/header/div/div[2]/div/div/a";

  @FindBy(xpath = SIGN_IN_BUTTON)
  private WebElement signInButton;

  @FindBy(xpath = SIGN_UP_BUTTON)
  private WebElement signUpButton;

  /**
   * Constructor for GitHubMainPage.
   *
   * @param webDriver - WebDriver instance used for interacting with the browser.
   */
  public GitHubMainPage(WebDriver webDriver) {
    super(webDriver);
    waitForPageToLoad();
  }

  private void waitForPageToLoad() {
    super.waitForPageToLoad(signInButton, signUpButton);
  }

  /** This method clicks the sign-in button on the GitHub main page. */
  public void selectSignInOption() {
    signInButton.click();
  }

  /** This method clicks the sign-up button on the GitHub main page. */
  public void selectSignUpOption() {
    signUpButton.click();
  }
}
