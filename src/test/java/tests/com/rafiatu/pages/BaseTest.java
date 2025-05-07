package tests.com.rafiatu.pages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected final String BASE_URL = "https://www.saucedemo.com/";

    public BaseTest() {
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        /**
         boolean isCI = System.getenv("CI") != null;
         if (isCI) {
         options.addArguments(new String[]{"--headless"});
         options.addArguments(new String[]{"--no-sandbox"});
         options.addArguments(new String[]{"--disable-dev-shm-usage"});
         }
         **/

        options.addArguments("--headless");
        options.addArguments(new String[]{"--window-size=1920,1080"});
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--disable-extensions"});
        options.addArguments(new String[]{"--disable-gpu"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        this.driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}