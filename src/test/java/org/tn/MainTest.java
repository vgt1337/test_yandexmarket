package org.tn;

import org.testng.annotations.Test;
import org.tn.Methods.PageManager;
import org.tn.Methods.Tests;


public class MainTest extends Tests
{
    @Test(alwaysRun= true)
    public void Test()
    {
        shouldLocate();
        goToComputersPage();
        goToNotebooksPage();
        applyFilter();

        PageManager.waitSomeInterval(10);
    }
}
