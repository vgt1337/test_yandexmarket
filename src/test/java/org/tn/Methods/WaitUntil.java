package org.tn.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tn.Settings.BaseTest;

import java.time.Duration;

public class WaitUntil extends BaseTest
{
    public static void waitSomeInterval(Integer seconds)
    {
        try
        {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

    public void shouldLocate(String location)
    {
        try
        {
            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains((location)));
        }
        catch (TimeoutException ex)
        {
            throw new NotFoundException("Проблема с подключением: "+location, ex);
        }
    }

    public static void waitElementUniversal(WebDriver webDriver, By locator, Integer seconds)
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitElementVisible(WebDriver webDriver, By locator, Integer seconds)
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitElementExists(WebDriver webDriver, By locator, Integer seconds )
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.	presenceOfElementLocated(locator));
    }
}
