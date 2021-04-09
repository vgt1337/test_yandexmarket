package org.tn.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.tn.PageObject.ComputerTechnologyPageObject;
import org.tn.PageObject.NotebookFilterPageObject;
import org.tn.PageObject.StartPageObject;
import org.tn.Settings.Driver;
import org.tn.Settings.NotebookFilterSpecifications;
import org.tn.Settings.TestSettings;

public class Tests extends PageManager
{

    public void shouldLocate()
    {
        PageManager pageManager = PageFactory.initElements(Driver.webDriver, PageManager.class);
        pageManager.shouldLocate(TestSettings.HostPrefix);
    }
    public void goToComputersPage()
    {
        StartPageObject startPage = PageFactory.initElements(Driver.webDriver, StartPageObject.class);
        startPage.goToComputersPage();
    }

    public void goToNotebooksPage()
    {
        ComputerTechnologyPageObject computerTechnologyPage = PageFactory.initElements(Driver.webDriver, ComputerTechnologyPageObject.class);
        computerTechnologyPage.goToNotebooksPage();
    }

    public void applyTillPriceFilter(String price)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyTillPriceFilter(price);
    }

    public void applyNotebookModelFilter(String notebookmodel)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyNotebookModelFilter(notebookmodel);
    }
    public void applyNotebookColorBlackWhite(String color1, String color2)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyNotebookColor(color1);
        notebookFilterPage.applyNotebookColor(color2);
    }
}
