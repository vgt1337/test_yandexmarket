package org.tn.Methods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tn.Settings.BaseTest;

import java.time.Duration;

public class PageElementsManager extends BaseTest
{

    public void shouldLocate(String location)
    {
        try
        {
            new WebDriverWait(BaseTest.webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains((location)));
        }
        catch (TimeoutException ex)
        {
            throw new NotFoundException("Проблема с подключением: "+location, ex);
        }
    }

    public void waitLocatorUniversal(By locator, Integer seconds)
    {
        new WebDriverWait(BaseTest.webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        new WebDriverWait(BaseTest.webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementUniversal(WebElement element, Integer seconds)
    {
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitLocatorVisible(By locator, Integer seconds)
    {
        new WebDriverWait(BaseTest.webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementVisible(WebElement element, Integer seconds)
    {
        new WebDriverWait(BaseTest.webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitLocatorExists(By locator, Integer seconds )
    {
        new WebDriverWait(BaseTest.webDriver, Duration.ofSeconds(seconds)).until(ExpectedConditions.	presenceOfElementLocated(locator));
    }

    public Boolean findSingleLocator(By locator)
    {
        try
        {
            BaseTest.webDriver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }

        catch (StaleElementReferenceException ex)
        {
            return (findSingleLocator(locator));
        }
    }


    public Boolean findSingleLocatorAndClick(By locator)
    {
        try
        {
            BaseTest.webDriver.findElement(locator).click();
            return true;
        }

        catch (NoSuchElementException ex)
        {
            return false;
        }
        catch (StaleElementReferenceException ex)
        {
            return (findSingleLocatorAndClick(locator));
        }
    }

    public Boolean findSingleElementAndClick(WebElement element)
    {
        try
        {
            element.click();
            return true;
        }

        catch (NoSuchElementException ex)
        {
            return false;
        }
        catch (StaleElementReferenceException ex)
        {
            return (findSingleElementAndClick(element));
        }
    }

    public Boolean findSingleLocatorAndSendKeys(By locator, String value)
    {
        try
        {
            BaseTest.webDriver.findElement(locator).sendKeys(value);
            return true;
        }

        catch (NoSuchElementException ex)
        {
            return false;
        }

        catch (StaleElementReferenceException ex)
        {
            return (findSingleLocatorAndSendKeys(locator, value));
        }
    }

    public Boolean findSingleElementAndSendKeys(WebElement element, String value)
    {
        try
        {
            element.sendKeys(value);
            return true;
        }

        catch (NoSuchElementException ex)
        {
            return false;
        }

        catch (StaleElementReferenceException ex)
        {
            return (findSingleElementAndSendKeys(element, value));
        }
    }
}
