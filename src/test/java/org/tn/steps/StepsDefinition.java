package org.tn.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.*;
import org.tn.Methods.Tests;
import org.tn.Settings.NotebookFilterSpecifications;

public class StepsDefinition extends Tests
{
    @Before()
    public void DoBeforeEachTheTests()
    {
        InitDriver();
    }

    @After()
    public void DoAfterEachTheTests()
    {
        CloseDriver();
    }

    @Test(priority = 1)
    @Given("Go To Page Computer Technology")
    public void goToPageComputerTechnology()
    {
        shouldLocate();
        goToComputersPage();
    }

    @Test(dependsOnMethods = "goToPageComputerTechnology")
    @When("Go To Page Notebook")
    public void goToPageNotebook()
    {
        goToNotebooksPage();
    }

    @Test(dependsOnMethods = "goToPageNotebook")
    @Then("Apply Filter Price {string}")
    public void applyFilterPrice(String price)
    {
        applyTillPriceFilter(NotebookFilterSpecifications.TillPrice);
    }

    @Test(dependsOnMethods = "applyFilterPrice")
    @And("Apply Filter Model {string}, {string}")
    public void applyFilterModel(String model1, String model2)
    {
        applyNotebookModelFilter(NotebookFilterSpecifications.ModelsName[0]);
        applyNotebookModelFilter(NotebookFilterSpecifications.ModelsName[1]);
    }

    @Test(dependsOnMethods = "applyFilterModel")
    @And("Apply Filter Color {string}, {string}")
    public void applyFilterColor(String color1, String color2)
    {
        applyNotebookColorBlackWhite(NotebookFilterSpecifications.BlackColor[1], NotebookFilterSpecifications.WhiteColor[1]);
    }
}
