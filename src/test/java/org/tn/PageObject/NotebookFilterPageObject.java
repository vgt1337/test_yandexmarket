package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.CheckElement;
import org.tn.Methods.WaitUntil;
import org.tn.Settings.NotebookFilterSpecifications;

public class NotebookFilterPageObject
{
    private WebDriver _webDriver;

    @FindBy(xpath = "//label[contains(text(), 'Цена, ₽ до')]/parent::span/descendant::input[@type='text']")
    private final By _tillPriceField = By.xpath("//label[contains(text(), 'Цена, ₽ до')]/parent::span/descendant::input[@type='text']");

    private final By _manufacturerListButton = By.xpath("");
    private final By _HPNameButton = By.xpath("//div[@data-tid='d03e142c ef8a0c6e eaa8d39b']/descendant::span[contains(text(), '"
            + NotebookFilterSpecifications.ModelsName[0] +"')]");
    private final By _PrestigioNameButton = By.xpath("//div[@data-tid='d03e142c ef8a0c6e eaa8d39b']/descendant::span[contains(text(), '"
            + NotebookFilterSpecifications.ModelsName[1] +"')]");
    private final By _whiteColorButton = By.xpath("");
    private final By _blackColorButton = By.xpath("");

    public NotebookFilterPageObject(WebDriver webDriver)
    {
        _webDriver = webDriver;
    }

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
        WaitUntil.waitElementUniversal(_webDriver,_tillPriceField, 10);
        CheckElement.findSingleElementAndSendKeys(_webDriver, _tillPriceField, price);
    }

    public void applyNotebookModelHPFilter(String notebookmodel)
    {

        switch (notebookmodel)
        {
            case "HP":
                WaitUntil.waitElementUniversal(_webDriver,_HPNameButton, 10);
                CheckElement.findSingleElementAndClick(_webDriver, _HPNameButton);
                break;
            case "Prestigio":
                WaitUntil.waitElementUniversal(_webDriver,_PrestigioNameButton, 10);
                CheckElement.findSingleElementAndClick(_webDriver, _PrestigioNameButton);
                break;
        }
    }
}
