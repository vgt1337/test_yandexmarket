package org.tn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class StartPageObject
{
    private WebDriver _webDriver;

    private final By _computersButton = By.xpath("//span[contains(text(),'Компьютеры')]");

    public StartPageObject(WebDriver webDriver)
    {
        _webDriver = webDriver;
    }

    public void GoToComputersPage()
    {
        WaitUntil.WaitElementUniversal(_webDriver, _computersButton, 10);
        CheckElement.FindSingleElementAndClick(_webDriver, _computersButton);
    }
}
