package org.tn.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tn.PageObject.ComputerTechnologyPageObject;
import org.tn.PageObject.NotebookFilterPageObject;
import org.tn.PageObject.StartPageObject;
import org.tn.Settings.BaseTest;
import org.tn.Settings.TestSettings;

public class Tests extends BaseTest
{
    private final PageManager pageManager = PageFactory.initElements(BaseTest.webDriver, PageManager.class);
    private final PageElementsManager pageElementsManager = PageFactory.initElements(BaseTest.webDriver, PageElementsManager.class);
    private final StartPageObject startPageObject = PageFactory.initElements(BaseTest.webDriver, StartPageObject.class);
    private final ComputerTechnologyPageObject computerTechnologyPageObject = new ComputerTechnologyPageObject();
    private final NotebookFilterPageObject notebookFilterPageObject = new NotebookFilterPageObject();

    public void shouldLocate()
    {
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

    public void applyNotebookModelHPFilter(String notebookmodel)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(BaseTest.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyNotebookModelHPFilter(notebookmodel);
    }
}
