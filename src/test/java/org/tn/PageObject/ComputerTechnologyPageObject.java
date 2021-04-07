package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.CheckElement;
import org.tn.Methods.PageManager;
import org.tn.Methods.WaitUntil;

public class ComputerTechnologyPageObject extends PageManager
{

    @FindBy(xpath = "//div[contains(text(),'Ноутбуки')]/parent::div")
    private WebElement notebookButton;


    public void goToNotebooksPage()
    {
        waitAndClickElement(notebookButton, 10);
    }
}
