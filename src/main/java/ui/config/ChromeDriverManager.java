package ui.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * ChromeDriverManager is a utility class for managing the ChromeDriver service and creating a
 * WebDriver instance.
 */
public class ChromeDriverManager {
  public WebDriver driver;
  private ChromeDriverService chromeDriverService;

  /**
   * Starts the ChromeDriver service.
   *
   * @throws URISyntaxException if the URI syntax is incorrect
   * @throws IOException if an I/O error occurs
   */
  public void startService() throws URISyntaxException, IOException {
    final Path chromeDriverPath =
        Paths.get(
            Objects.requireNonNull(getClass().getResource("/chromedriver/winx64/chromedriver.exe"))
                .toURI());
    chromeDriverService =
        new ChromeDriverService.Builder()
            .usingDriverExecutable(chromeDriverPath.toFile())
            .usingAnyFreePort()
            .build();
    chromeDriverService.start();
  }

  /** Creates a new ChromeDriver instance with specified options. */
  public void createDriver() {
    final ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("ignore-ssl-errors=yes");
    chromeOptions.addArguments("ignore-certificate-errors");
    chromeOptions.addArguments("start-maximized");
    chromeOptions.addArguments("--force-device-scale-factor=1");
    chromeOptions.addArguments("--remote-allow-origins=*");
    // chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--disable-gpu");
    this.driver = new ChromeDriver(chromeDriverService, chromeOptions);
  }

  /**
   * Returns the WebDriver instance. If the driver is not initialized, it starts the service and
   * creates a new driver instance.
   *
   * @return WebDriver instance
   * @throws URISyntaxException if the URI syntax is incorrect
   * @throws IOException if an I/O error occurs
   */
  public WebDriver getDriver() throws URISyntaxException, IOException {
    if (driver == null) {
      startService();
      createDriver();
    }
    return this.driver;
  }

  /** Quits the WebDriver and stops the ChromeDriver service. */
  public void quitDriver() {
    if (driver != null) {
      this.driver.quit();
      this.driver = null;
    }
  }
}
