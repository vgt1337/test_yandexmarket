package org.tn.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tn.Methods.PageManager;
import org.tn.Settings.NotebookPower;

import java.util.ArrayList;

public class NotebookDetailCharacteristics extends PageManager
{
    private final By notebookPowerElements = By.xpath("//div[@data-tid='b0ee0d2c']/descendant::h3[contains(text(),'Питание')]/following-sibling::div/descendant::div[@class='b_jgixRQsL0c']/child::span");

    @FindBy(xpath = "//div[@data-tid='b85f63a7']")
    private WebElement firstPopUpButton;

    @FindBy(xpath = "//div[@class='b_3yqfKNY_vn']/child::span")
    private WebElement firstPopUpTextField;


    public NotebookPower getPowerInfo()
    {
        waitLocatorVisible(notebookPowerElements, 10);

        ArrayList<String> list = new ArrayList<String>();
        list = listOfTextElements(notebookPowerElements);

        NotebookPower notebookPower = new NotebookPower();

        if(list.size()==4)
        {
            notebookPower.workingTime = list.get(0);
            notebookPower.batteryCapacity = list.get(1);
            notebookPower.numberOfBattery = list.get(2);
            notebookPower.batteryType = list.get(3);
        }
        else if(list.size()==3)
        {
            notebookPower.workingTime = null;
            notebookPower.batteryCapacity = list.get(0);
            notebookPower.numberOfBattery = list.get(1);
            notebookPower.batteryType = list.get(2);
        }

        return notebookPower;
    }

    public String getPopUpText()
    {
        waitElementUniversal(firstPopUpButton, 10);
        findSingleElementAndClick(firstPopUpButton);

        waitElementVisible(firstPopUpTextField, 10);
        return getTextElement(firstPopUpTextField);
    }

}
