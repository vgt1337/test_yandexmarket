package org.tn.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class CheckElement
{
    public static Boolean findSingleElement(WebDriver webdriver, By locator)
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
            return (findSingleElement(webdriver, locator));
        }
    }

    public static Boolean findSingleElementAndClick(WebDriver webdriver, By locator)
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
            return (findSingleElementAndClick(webdriver, locator));
        }
    }

    public static Boolean findSingleElementAndSendKeys(WebDriver webdriver, By locator, String value)
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
            return (findSingleElementAndSendKeys(webdriver, locator, value));
        }
    }
}
