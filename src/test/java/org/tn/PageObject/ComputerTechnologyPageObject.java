package org.tn.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.PageManager;

public class ComputerTechnologyPageObject extends PageManager
{

    @FindBy(xpath = "//div[@class='_3D53RUXFhW']/descendant::div[contains(text(),'Ноутбуки')]/ancestor::div[@class='_3D53RUXFhW']")
    private WebElement notebookButton;


    public void goToNotebooksPage()
    {
        waitAndClickElement(notebookButton, 10);
    }
}
