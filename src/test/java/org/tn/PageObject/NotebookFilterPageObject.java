package org.tn.PageObject;

import io.cucumber.java.mn.Харин;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.PageManager;
import org.tn.Settings.NotebookFilterSpecifications;

public class NotebookFilterPageObject extends PageManager
{

    @FindBy(xpath = "//label[contains(text(), 'Цена, ₽ до')]/parent::span/descendant::input[@type='text']")
    private WebElement tillPriceField;
    private final By tillPriceFilterCheckButton = By.xpath("//div[@data-tid='b0f6317d']/descendant::span[contains(text(), '"+NotebookFilterSpecifications.TillPrice+"')]");

    @FindBy(xpath = "//label[contains(text(), 'Найти производителя')]/ancestor::div[@data-tid='2b1bdec8 a219b6c7 1ec904c8']/descendant::span[@data-tid='1305f43b']")
    private WebElement manufacturerListButton;

    private final By hPNameButton = By.xpath("//div[@data-tid='2b1bdec8 a219b6c7 1ec904c8']/descendant::span[contains(text(), '"
            + NotebookFilterSpecifications.ModelsName[0] +"')]");
    private final By hPNameFilterCheckButton = By.xpath("//div[@data-tid='b0f6317d']/descendant:: span[contains(text(), '"+NotebookFilterSpecifications.ModelsName[0]+"')]");

    private final By prestigioNameButton = By.xpath("//div[@data-tid='2b1bdec8 a219b6c7 1ec904c8']/descendant::span[contains(text(), '"
            + NotebookFilterSpecifications.ModelsName[1] +"')]");
    private final By prestigioNameFilterCheckButton = By.xpath("//div[@data-tid='b0f6317d']/descendant:: span[contains(text(), '"+NotebookFilterSpecifications.ModelsName[1]+"')]");

    private final By whiteColorButton = By.xpath("//span[@style='"+ NotebookFilterSpecifications.WhiteColor[0] +"']/parent::div/parent::label");
    private final By whiteColorFilterCheckButton = By.xpath("//div[@data-tid='b0f6317d']/descendant:: span[contains(text(), '"+NotebookFilterSpecifications.WhiteColor[2]+"')]");

    private final By blackColorButton = By.xpath("//span[@style='"+ NotebookFilterSpecifications.BlackColor[0] +"']/parent::div/parent::label");
    private final By blackColorFilterCheckButton = By.xpath("//div[@data-tid='b0f6317d']/descendant:: span[contains(text(), '"+NotebookFilterSpecifications.BlackColor[2]+"')]");


    public void applyFilter()
    {
        applyTillPriceFilter(NotebookFilterSpecifications.TillPrice);
        for (String i:NotebookFilterSpecifications.ModelsName)
        {
            applyNotebookModelFilter(i);
        }
    }

    public void applyTillPriceFilter(String price)
    {
        waitElementUniversal(tillPriceField, 10);
        findSingleElementAndClear(tillPriceField);
        waitElementAndSendKeys(tillPriceField, 10, price);
        checkFilter(tillPriceFilterCheckButton, 10);
        waitAndClickElement(manufacturerListButton, 10);
    }

    public void applyNotebookModelFilter(String notebookmodel)
    {

        switch (notebookmodel)
        {
            case "HP":
                waitAndClickLocator(hPNameButton, 10);
                checkFilter(hPNameFilterCheckButton, 10);
                break;
            case "Prestigio":
                waitAndClickLocator(prestigioNameButton, 10);
                checkFilter(prestigioNameFilterCheckButton, 10);
                break;
        }
    }

    public void applyNotebookColor(String color)
    {
        try
        {
            if (color.equals(NotebookFilterSpecifications.WhiteColor[1]))
            {
                waitAndClickLocator(whiteColorButton, 10);
                checkFilter(whiteColorFilterCheckButton, 10);
            }
            else if(color.equals(NotebookFilterSpecifications.BlackColor[1]))
            {
                waitAndClickLocator(blackColorButton, 10);
                checkFilter(blackColorFilterCheckButton, 10);
            }
        }
        catch(Exception e)
        {

        }

    }

    public void checkFilter(By locator, Integer seconds)
    {
        waitLocatorClickable(locator, seconds);
    }
}
