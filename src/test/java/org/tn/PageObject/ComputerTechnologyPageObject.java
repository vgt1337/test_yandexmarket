package org.tn.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.PageManager;

public class ComputerTechnologyPageObject extends PageManager
{

    @FindBy(xpath = "//div[contains(text(),'Ноутбуки')]/parent::div")
    private WebElement notebookButton;


    public void goToNotebooksPage()
    {
        waitAndClickElement(notebookButton, 10);
    }
}
