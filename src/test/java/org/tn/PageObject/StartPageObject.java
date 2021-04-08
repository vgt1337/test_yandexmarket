package org.tn.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.PageManager;

public class StartPageObject extends PageManager
{
    @FindBy(xpath ="//span[contains(text(),'Компьютеры')]")
    private WebElement computersButton ;



    public void goToComputersPage()
    {
        waitAndClickElement(computersButton, 10);
    }
}
