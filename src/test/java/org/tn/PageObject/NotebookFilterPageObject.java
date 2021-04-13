package org.tn.PageObject;

import io.cucumber.java.mn.Харин;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.PageManager;
import org.tn.Settings.Driver;
import org.tn.Settings.NotebookFilterSpecifications;

import java.util.ArrayList;

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

    @FindBy(xpath = "//button[@class='b_hLFQgGdG9d b_3YbI1T0fRW b_2-RRRko_cC b_tsRVwTUEda b_J-RVT98dW- _brandTheme_default']")
    private WebElement priceQueueButton;

    @FindBy(xpath = "//li/descendant::span[contains(text(),'Сначала подешевле')]")
    private WebElement lowPriceQueueButton;

    @FindBy(xpath = "//li/descendant::span[contains(text(),'Сначала подороже')]")
    private WebElement highPriceQueueButton;

    @FindBy(xpath = "//div[@data-tid='2bd11028 e16f1c46']/descendant::span[@data-tid='6a41b9c2 3b85e3a2']")
    private WebElement priceOfFirstInQueueField;

    @FindBy(xpath = "//div[@data-tid='2bd11028 e16f1c46']/descendant::div[@class='b_3bNl7A8hOl b_rDpH_6iq3d']/descendant::span")
    private WebElement nameOfFirstInQueueField;
    private final By nameOfFirstInQueueList = By.xpath("//div[@data-tid='2bd11028 e16f1c46']/descendant::div[@class='b_3bNl7A8hOl b_rDpH_6iq3d']/descendant::span");

    @FindBy(xpath = "//span[@data-tid='2905e1c2']")
    private WebElement loadingMark;

    @FindBy(xpath = "//div[@class='b_2TiXwODAcc']/a")
    private WebElement allСharacteristicsButton;

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

    public void applyPriceQueue(String queue)
    {
        waitAndClickElement(priceQueueButton, 10);
        switch (queue)
        {
            case ("low"):
                waitAndClickElement(lowPriceQueueButton, 10);
                break;
            case ("high"):
                waitAndClickElement(highPriceQueueButton, 10);
                break;
        }
    }

    public Boolean checkLoading()
    {
        waitElementVisible(loadingMark, 5);
        return waitElementStaleness(loadingMark, 2);
    }

    public String getNameFirstNotebook()
    {
        return getTextElement(nameOfFirstInQueueField);
    }

    public String getPriceFirstNotebook()
    {
        return getTextElement(priceOfFirstInQueueField);
    }

    public ArrayList<String> notebooksList()
    {
        return listOfTextElements(nameOfFirstInQueueList);
    }

    public void goToNotebooksListOfElements(Integer count)
    {

        var list = listOfElements(nameOfFirstInQueueList);
        WebElement element = list.get(count);
        waitAndClickElement(element, 10);

        ArrayList<String> tabs = new ArrayList<String> (Driver.webDriver.getWindowHandles());
        SwithcWindow(1);

        waitAndClickElement(allСharacteristicsButton, 10);
    }
}
