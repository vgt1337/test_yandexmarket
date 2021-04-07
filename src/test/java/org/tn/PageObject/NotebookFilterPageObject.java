package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.CheckElement;
import org.tn.Methods.PageManager;
import org.tn.Methods.WaitUntil;
import org.tn.Settings.NotebookFilterSpecifications;

public class NotebookFilterPageObject extends PageManager
{

    @FindBy(xpath = "//label[contains(text(), 'Цена, ₽ до')]/parent::span/descendant::input[@type='text']")
    private WebElement tillPriceField;

    @FindBy(xpath = "")
    private WebElement manufacturerListButton;

    private final By HPNameButton = By.xpath("//div[@data-tid='d03e142c ef8a0c6e eaa8d39b']/descendant::span[contains(text(), '"
            + NotebookFilterSpecifications.ModelsName[0] +"')]");
    private final By PrestigioNameButton = By.xpath("//div[@data-tid='d03e142c ef8a0c6e eaa8d39b']/descendant::span[contains(text(), '"
            + NotebookFilterSpecifications.ModelsName[1] +"')]");

    @FindBy(xpath = "")
    private WebElement whiteColorButton;

    @FindBy(xpath = "")
    private WebElement blackColorButton;


    public void applyFilter()
    {
        applyTillPriceFilter(NotebookFilterSpecifications.TillPrice);
        for (String i:NotebookFilterSpecifications.ModelsName)
        {
            applyNotebookModelHPFilter(i);
        }
    }

    public void applyTillPriceFilter(String price)
    {
        waitElementAndSendKeys(tillPriceField, 10, price);
    }

    public void applyNotebookModelHPFilter(String notebookmodel)
    {

        switch (notebookmodel)
        {
            case "HP":
                waitAndClickLocator(HPNameButton, 10);
                break;
            case "Prestigio":
                waitAndClickLocator(PrestigioNameButton, 10);
                break;
        }
    }
}
