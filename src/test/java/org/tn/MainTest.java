package org.tn;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.tn.Methods.Tests;
import org.tn.Methods.WaitUntil;


public class MainTest extends Tests
{
    @Test
    public void Test()
    {
        shouldLocate();
        goToComputersPage();
        goToNotebooksPage();
        applyFilter();

        //WaitUntil.waitSomeInterval(5);
    }
}
