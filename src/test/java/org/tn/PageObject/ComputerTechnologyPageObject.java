package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tn.Methods.CheckElement;
import org.tn.Methods.WaitUntil;

public class ComputerTechnologyPageObject
{
    private WebDriver _webDriver;

    private final By _notebookButton = By.xpath("//div[contains(text(),'Ноутбуки')]/parent::div");

    public ComputerTechnologyPageObject(WebDriver webDriver)
    {
        _webDriver = webDriver;
    }

    public void goToNotebooksPage()
    {
        WaitUntil.waitElementUniversal(_webDriver, _notebookButton, 10);
        CheckElement.findSingleElementAndClick(_webDriver, _notebookButton);
    }
}
