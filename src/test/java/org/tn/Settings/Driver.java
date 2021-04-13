package org.tn.Settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Driver
{
    public static WebDriver webDriver;

    public void InitDriver()
    {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.OFF);
        logs.enable(LogType.CLIENT, Level.OFF);
        logs.enable(LogType.DRIVER, Level.OFF);
        logs.enable(LogType.PERFORMANCE, Level.OFF);
        logs.enable(LogType.SERVER, Level.OFF);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

        switch (TestSettings.BrowserSelect)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions сhromeoptions = new ChromeOptions();
                webDriver = new ChromeDriver(сhromeoptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions(desiredCapabilities);
                webDriver = new FirefoxDriver(firefoxoptions);
                break;
        }
        LogManager.getLogManager().reset();
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
