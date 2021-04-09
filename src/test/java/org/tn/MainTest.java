package org.tn;

import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/org.tn/resourses"},
        glue = {"steps"}, plugin = {"pretty"})

public class MainTest
{
    @Test(alwaysRun= true)
    public void Test()
    {

    }
}
