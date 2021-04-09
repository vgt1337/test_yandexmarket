package org.tn;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/resourses"},
        glue = {"org/tn/steps"}, plugin = {"pretty"})

public class MainTest extends AbstractTestNGCucumberTests
{

}
