package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tn.Methods.CheckElement;
import org.tn.Methods.WaitUntil;

public class StartPageObject
{
    private WebDriver _webDriver;

    private final By _computersButton = By.xpath("//span[contains(text(),'Компьютеры')]");

    public StartPageObject(WebDriver webDriver)
    {
        _webDriver = webDriver;
    }

    public void goToComputersPage()
    {
        WaitUntil.waitElementUniversal(_webDriver, _computersButton, 10);
        CheckElement.findSingleElementAndClick(_webDriver, _computersButton);
    }
}
