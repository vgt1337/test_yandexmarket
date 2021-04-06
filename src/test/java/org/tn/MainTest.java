package org.tn;

import org.junit.Test;

public class MainTest extends BaseTest
{
    @Test()
    public void Test()
    {
        WaitUntil.ShouldLocate( _webDriver, TestSettings.HostPrefix);

        StartPageObject startPageObject = new StartPageObject(_webDriver);
        startPageObject.GoToComputersPage();

        ComputerTechnologyPageObject technoListPageObject = new ComputerTechnologyPageObject(_webDriver);
        technoListPageObject.GoToNotebooksPage();
    }
}
