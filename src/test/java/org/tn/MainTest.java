package org.tn;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/resourses"},
        glue = {"org/tn/steps"}, plugin = {"pretty"})

@Epic("Регрессионное тестирование")
@Feature("Тестирование по ТЗ")
public class MainTest extends AbstractTestNGCucumberTests
{

}
