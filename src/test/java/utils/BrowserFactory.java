package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public WebDriver startBrowser(String browserName, String url) {

        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--remote-allow-origins=*"); // Chrome 115+
                driver = new ChromeDriver(options);
                break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "safari": driver = new SafariDriver(); break;
            default:
                System.out.println("Browser not recognized, defaulting to Chrome");
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
