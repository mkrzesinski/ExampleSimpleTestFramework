package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ConfigProvider is a utility class that loads properties from a configuration file and provides
 * methods to access those properties.
 */
public class ConfigProvider {
  private static final Properties properties = new Properties();

  static {
    InputStream input =
        ConfigProvider.class.getClassLoader().getResourceAsStream("test.properties");
    try {
      properties.load(input);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns the value of the specified property key.
   *
   * @param key - The property key to look up.
   * @return The value of the property key.
   */
  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
