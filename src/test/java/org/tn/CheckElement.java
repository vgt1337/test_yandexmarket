package org.tn;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class CheckElement
{
    public static Boolean FindSingleElement(WebDriver webdriver, By locator)
    {
        try
        {
            webdriver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }

        catch (StaleElementReferenceException ex)
        {
            return (FindSingleElement(webdriver, locator));
        }
    }

    public static Boolean FindSingleElementAndClick(WebDriver webdriver, By locator)
    {
        try
        {
            webdriver.findElement(locator).click();
            return true;
        }

        catch (NoSuchElementException ex)
        {
            return false;
        }
        catch (StaleElementReferenceException ex)
        {
            return (FindSingleElementAndClick(webdriver, locator));
        }
    }

    public static Boolean FindSingleElementAndSendKeys(WebDriver webdriver, By locator, String value)
    {
        try
        {
            webdriver.findElement(locator).sendKeys(value);
            return true;
        }

        catch (NoSuchElementException ex)
        {
            return false;
        }

        catch (StaleElementReferenceException ex)
        {
            return (FindSingleElementAndSendKeys(webdriver, locator, value));
        }
    }
}
