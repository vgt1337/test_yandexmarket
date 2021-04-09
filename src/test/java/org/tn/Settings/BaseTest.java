package org.tn.Settings;

import org.testng.annotations.*;

public class BaseTest extends Driver
{
    @AfterClass
    public void DoafterEachClass()
    {

    }

    @BeforeSuite
    public void DoBeforeAllTheTests()
    {

    }

    @AfterSuite
    public void DoAfterAllTheTests()
    {
        CloseDriver();
    }

    @BeforeTest(alwaysRun= true)
    public void DoBeforeEachTheTests()
    {
        InitDriver();
    }

    @AfterTest(alwaysRun= true)
    public void DoAfterEachTheTests()
    {
        CloseDriver();
    }

}
