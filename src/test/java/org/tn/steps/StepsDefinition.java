package org.tn.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import org.tn.Methods.Tests;
import org.tn.Settings.NotebookFilterSpecifications;

public class StepsDefinition extends Tests
{
    @Before()
    @Step("Инициализация драйвера, подготовка к запуску тестов, переход на стартовую страницу Yandex.Market...")
    public void DoBeforeEachTheTests()
    {
        InitDriver();
    }

    @After()
    @Step("Завершение работы, закрытие драйвера")
    public void DoAfterEachTheTests()
    {
        CloseDriver();
    }

    @Test(priority = 1)
    @Step("Переход на страницу 'Компьютерная техника'")
    @Given("Go To Page Computer Technology")
    public void goToPageComputerTechnology()
    {
        shouldLocate();
        goToComputersPage();
    }

    @Test(dependsOnMethods = "goToPageComputerTechnology")
    @Step("Переход на страницу 'Ноутбуки'")
    @When("Go To Page Notebook")
    public void goToPageNotebook()
    {
        goToNotebooksPage();
    }

    @Test(dependsOnMethods = "goToPageNotebook")
    @Step("Применение фильтра 'Цена до 30 000 руб.'")
    @Then("Apply Filter Price {string}")
    public void applyFilterPrice(String price)
    {
        applyTillPriceFilter(NotebookFilterSpecifications.TillPrice);
    }

    @Test(dependsOnMethods = "applyFilterPrice")
    @Step("Применение фильтра 'Производители: HP, Lenovo'")
    @And("Apply Filter Model {string}, {string}")
    public void applyFilterModel(String model1, String model2)
    {
        applyNotebookModelFilter(NotebookFilterSpecifications.ModelsName[0]);
        applyNotebookModelFilter(NotebookFilterSpecifications.ModelsName[1]);
    }

    @Test(dependsOnMethods = "applyFilterModel")
    @Step("Применение фильтра 'Цвет (при наличии): Черный, Белый'")
    @And("Apply Filter Color {string}, {string}")
    public void applyFilterColor(String color1, String color2)
    {
        applyNotebookColorBlackWhite(NotebookFilterSpecifications.BlackColor[1], NotebookFilterSpecifications.WhiteColor[1]);
    }

    @Test(dependsOnMethods = "applyFilterColor")
    @Step("Сравнение самой высокой и низкой цен на модели по примененным фильтрам")
    @And("Check Difference Price {string}, {string}")
    public void checkDifferencePrice(String low, String high)
    {
        checkDifferencePrice();
        sortedListOfNotebooks();
        mapOfNotebooks();
    }

    @Test(dependsOnMethods = "checkDifferencePrice")
    @Step("Сравнение блоков 'Питание' двух ноутбуков")
    @And("Check Equal Of Two Notebooks")
    public void checkEqualOfTwoNotebooks()
    {
        equalOfTwoNotebooks();

        parseJson();
        parseExcel();
        parseXML();
    }

    @Test(priority = 2)
    @Step("Поиск трех файлов: json, xml, excel")
    @When("Three Files Exist")
    public void threeFilesExist()
    {
        if (!checkFiles())
        {
            Assert.fail("Файл/ы не найден/ы!");
        }
    }

    @Test(dependsOnMethods = "threeFilesExist", priority = 3)
    @Step("Парсинг Json")
    @Then("Json Parse")
    public void jsonParse()
    {
        parseJson();
    }

    @Test(dependsOnMethods = "threeFilesExist", priority = 4)
    @Step("Парсинг Excel")
    @And("Excel Parse")
    public void excelParse()
    {
        parseExcel();
    }

    @Test(dependsOnMethods = "threeFilesExist", priority = 5)
    @Step("Парсинг XML")
    @And("xml Parse")
    public void xmlParse()
    {
        parseXML();
    }
}
