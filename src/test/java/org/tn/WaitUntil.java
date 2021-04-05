package org.tn;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUntil
{
    public static void ShouldLocate(WebDriver webDriver, String location)
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

    public static void WaitElementUniversal(WebDriver webDriver, By locator, Integer seconds)
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void WaitElementVisible(WebDriver webDriver, By locator, Integer seconds)
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void WaitElementExists(WebDriver webDriver, By locator, Integer seconds )
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.	presenceOfElementLocated(locator));
    }
}
