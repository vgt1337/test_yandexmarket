package org.tn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputerTechnologyPageObject
{
    private WebDriver _webDriver;

    private final By _notebookButton = By.xpath("//div[contains(text(),'Ноутбуки')]/parent::div");

    public ComputerTechnologyPageObject(WebDriver webDriver)
    {
        _webDriver = webDriver;
    }

    public void GoToNotebooksPage()
    {
        WaitUntil.WaitElementUniversal(_webDriver, _notebookButton, 10);
        CheckElement.FindSingleElementAndClick(_webDriver, _notebookButton);
    }
}
