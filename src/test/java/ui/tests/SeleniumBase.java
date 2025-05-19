package ui.tests;

import config.ConfigProvider;
import io.qameta.allure.testng.AllureTestNg;
import java.io.IOException;
import java.net.URISyntaxException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import ui.config.ChromeDriverManager;

@Listeners({AllureTestNg.class})
public class SeleniumBase {
  protected ChromeDriverManager chromeDriverManager;
  protected WebDriver webDriver;
  protected JavascriptExecutor javascriptExecutor;

  @BeforeClass
  public void setUp() throws URISyntaxException, IOException {
    this.chromeDriverManager = new ChromeDriverManager();
    this.webDriver = this.chromeDriverManager.getDriver();
    this.javascriptExecutor = (JavascriptExecutor) this.webDriver;
  }

  protected void navigateToMainPage() {
    webDriver.get(ConfigProvider.getProperty("initpage"));
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    webDriver.quit();
  }
}
