package org.tn.Methods;

import org.openqa.selenium.support.PageFactory;
import org.tn.PageObject.ComputerTechnologyPageObject;
import org.tn.PageObject.NotebookFilterPageObject;
import org.tn.PageObject.StartPageObject;
import org.tn.Settings.BaseTest;
import org.tn.Settings.TestSettings;

public class Tests extends PageManager
{


    public void shouldLocate()
    {
        PageManager pageManager = PageFactory.initElements(BaseTest.webDriver, PageManager.class);
        pageManager.shouldLocate(TestSettings.HostPrefix);
    }
    public void goToComputersPage()
    {
        StartPageObject startPage = PageFactory.initElements(BaseTest.webDriver, StartPageObject.class);
        startPage.goToComputersPage();
    }

    public void goToNotebooksPage()
    {
        ComputerTechnologyPageObject computerTechnologyPage = PageFactory.initElements(BaseTest.webDriver, ComputerTechnologyPageObject.class);
        computerTechnologyPage.goToNotebooksPage();
    }

    public void applyFilter()
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(BaseTest.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyFilter();
    }

    public void applyTillPriceFilter(String price)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(BaseTest.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyTillPriceFilter(price);
    }

    public void applyNotebookModelFilter(String notebookmodel)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(BaseTest.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyNotebookModelFilter(notebookmodel);
    }
}
