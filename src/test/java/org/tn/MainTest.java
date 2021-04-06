package org.tn;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.tn.Methods.WaitUntil;
import org.tn.PageObject.ComputerTechnologyPageObject;
import org.tn.PageObject.NotebookFilterPageObject;
import org.tn.PageObject.StartPageObject;
import org.tn.Settings.BaseTest;
import org.tn.Settings.TestSettings;

public class MainTest extends BaseTest
{
    @Test()
    public void Test()
    {
        WaitUntil.shouldLocate( _webDriver, TestSettings.HostPrefix);

        StartPageObject startPageObject = new StartPageObject(_webDriver);
        startPageObject.goToComputersPage();

        ComputerTechnologyPageObject technoListPageObject = new ComputerTechnologyPageObject(_webDriver);
        technoListPageObject.goToNotebooksPage();

        NotebookFilterPageObject Filter = PageFactory.initElements(_webDriver, NotebookFilterPageObject.class);
        Filter.applyFilter();
        WaitUntil.waitSomeInterval(10);
    }
}
