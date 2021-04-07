package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.CheckElement;
import org.tn.Methods.PageManager;
import org.tn.Methods.WaitUntil;

public class StartPageObject extends PageManager
{
    @FindBy(xpath ="//span[contains(text(),'Компьютеры')]")
    private WebElement computersButton ;



    public void goToComputersPage()
    {
        waitAndClickElement(computersButton, 10);
    }
}
