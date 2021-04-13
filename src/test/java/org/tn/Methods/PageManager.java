package org.tn.Methods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tn.Settings.Driver;
import java.time.Duration;

import static org.tn.Methods.AllureAttachment.addActionDescription;

public class PageManager extends PageElementsManager
{

    public void shouldLocate(String location)
    {
        try
        {
            addActionDescription("Проверка коннекта к URL: "+location);
            new WebDriverWait(Driver.webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains((location)));
        }
        catch (TimeoutException ex)
        {
            throw new NotFoundException("Проблема с подключением: "+location, ex);
        }
    }

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

    public void waitElementAndSendKeys(WebElement element, Integer seconds, String value)
    {
        addActionDescription("Передача значения "+value+" в поле: "+element);
        waitElementUniversal(element, seconds);
        findSingleElementAndSendKeys(element, value);
    }

    public void waitLocatorAndSendKeys(By locator, Integer seconds, String value)
    {
        waitLocatorUniversal(locator, seconds);
        findSingleLocatorAndSendKeys(locator, value);
    }

    public void waitAndClickElement(WebElement element, Integer seconds)
    {
        addActionDescription("Клик по элементу "+element);
        waitElementUniversal(element, seconds);
        findSingleElementAndClick(element);
    }

    public void waitAndClickLocator(By locator, Integer seconds)
    {
        addActionDescription("Клик по локатору "+locator);
        waitLocatorClickable(locator, seconds);
        findSingleLocatorAndClick(locator);
    }


}
