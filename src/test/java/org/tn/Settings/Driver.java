package org.tn.Settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;

public class Driver
{
    public static WebDriver webDriver;

    public void InitDriver()
    {
        switch (TestSettings.BrowserSelect)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions сhromeoptions = new ChromeOptions();
                webDriver = new ChromeDriver(сhromeoptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                webDriver = new FirefoxDriver(firefoxoptions);
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

    public void CloseWindow()
    {
        webDriver.close();
    }

    public void SwithcWindow(Integer windownumber)
    {
        ArrayList<String> tabs = new ArrayList<String> (Driver.webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(windownumber));
    }
}
