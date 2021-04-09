package org.tn.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tn.Methods.PageManager;
import org.tn.Methods.Tests;

public class StepsDefinition extends Tests
{
    @Given("Переход на главную страницу")
    public void goToStartPage()
    {
        InitDriver();
    }

    @Given("Переход на страницу Компьютерная техника")
    public void goToPageComputersTechnology()
    {
        goToComputersPage();
    }

    @When("Переход на страницу Ноутбуки")
    public void goToPageNotebooks()
    {
        goToNotebooksPage();
    }

    @Then("Применение фильтра цены {string}")
    public void applyFilterPrice(String price)
    {
        applyTillPriceFilter(price);
    }

    @And("Применение фильтра модели HP {string}")
    public void applyFilterNotebookModelHP(String model)
    {
        applyNotebookModelFilter(model);
    }

    @And("Применение фильтра модели Prestigio {string}")
    public void applyFilterNotebookModelPrestigio(String model)
    {
        applyNotebookModelFilter(model);
        CloseDriver();
    }
}
