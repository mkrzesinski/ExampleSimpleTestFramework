package ui.pages;

import static org.awaitility.Awaitility.await;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/** AbstractPage is a base class for all page objects in the UI tests. */
public abstract class AbstractPage {
  protected final WebDriver webDriver;
  protected final WebDriverWait webDriverWait;

  /**
   * Constructor for AbstractPage.
   *
   * @param webDriver - WebDriver instance used for interacting with the browser.
   */
  public AbstractPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
    this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
  }

  /**
   * Waits for the specified elements to be displayed on the page.
   *
   * @param elements - WebElements to wait for.
   */
  public void waitForPageToLoad(final WebElement... elements) {
    Arrays.asList(elements).forEach(element -> await().until(element::isDisplayed));
  }

  /**
   * CLick specified element.
   *
   * @param webElement - WebElement to click.
   */
  public void clickElement(WebElement webElement) {
    webElement.click();
  }

  /**
   * Refresh the page using JavaScript.
   *
   * @param javascriptExecutor - JavascriptExecutor instance used to execute JavaScript.
   */
  public void refreshPage(JavascriptExecutor javascriptExecutor) {
    javascriptExecutor.executeScript("window.location.reload(true);");
  }
}
