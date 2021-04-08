package org.tn.Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver
{
    public static WebDriver webDriver;

    public void InitDriver()
    {
        switch (TestSettings.BrowserSelect)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/vgt_/IdeaProjects/test_yandexmarket/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "firefox": webDriver = new FirefoxDriver();
                System.setProperty("webdriver.firefox.driver", "C:/Users/vgt_/IdeaProjects/test_yandexmarket/geckodriver.exe");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "C:/Users/vgt_/IdeaProjects/test_yandexmarket/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.get(TestSettings.HostPrefix);
    }

    public void CloseDriver()
    {
        webDriver.quit();
    }
}
