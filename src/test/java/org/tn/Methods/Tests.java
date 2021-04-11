package org.tn.Methods;
import io.cucumber.java.sl.In;
import org.openqa.selenium.support.PageFactory;
import org.tn.PageObject.ComputerTechnologyPageObject;
import org.tn.PageObject.NotebookDetailCharacteristics;
import org.tn.PageObject.NotebookFilterPageObject;
import org.tn.PageObject.StartPageObject;
import org.tn.Settings.Driver;
import org.tn.Settings.NotebookPower;
import org.tn.Settings.TestSettings;

import java.util.*;

public class Tests extends PageManager
{

    public void shouldLocate()
    {
        PageManager pageManager = PageFactory.initElements(Driver.webDriver, PageManager.class);
        pageManager.shouldLocate(TestSettings.HostPrefix);
    }
    public void goToComputersPage()
    {
        StartPageObject startPage = PageFactory.initElements(Driver.webDriver, StartPageObject.class);
        startPage.goToComputersPage();
    }

    public void goToNotebooksPage()
    {
        ComputerTechnologyPageObject computerTechnologyPage = PageFactory.initElements(Driver.webDriver, ComputerTechnologyPageObject.class);
        computerTechnologyPage.goToNotebooksPage();
    }

    public void applyTillPriceFilter(String price)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyTillPriceFilter(price);
    }

    public void applyNotebookModelFilter(String notebookmodel)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyNotebookModelFilter(notebookmodel);
    }
    public void applyNotebookColorBlackWhite(String color1, String color2)
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyNotebookColor(color1);
        notebookFilterPage.applyNotebookColor(color2);
    }

    public void checkDifferencePrice()
    {
        String firstNotebookName=null;
        String secondNotebookName=null;
        String firstNotebookPrice=null;
        String secondNotebookPrice=null;

        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        notebookFilterPage.applyPriceQueue("low");
        if (notebookFilterPage.checkLoading()==true)
            {
                firstNotebookName=notebookFilterPage.getNameFirstNotebook();
                firstNotebookPrice=notebookFilterPage.getPriceFirstNotebook().substring(0, notebookFilterPage.getPriceFirstNotebook().length()-1);
            }
        notebookFilterPage.applyPriceQueue("high");
        if (notebookFilterPage.checkLoading()==true)
            {
                secondNotebookName=notebookFilterPage.getNameFirstNotebook();
                secondNotebookPrice=notebookFilterPage.getPriceFirstNotebook().substring(0, notebookFilterPage.getPriceFirstNotebook().length()-1);
            }

        System.out.println("Самый дорогой ноутбук: "+firstNotebookName+" его цена: "+firstNotebookPrice);
        System.out.println("Самый дешевый ноутбук: "+secondNotebookName+" его цена: "+secondNotebookPrice);
        System.out.println("Разница в цене: "+(Integer.parseInt(secondNotebookPrice.replaceAll("\\s+",""))- Integer.parseInt(firstNotebookPrice.replaceAll("\\s+",""))));
    }

    public void sortedListOfNotebooks()
    {
        ArrayList<String> list = new ArrayList<String>();
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);

        list = notebookFilterPage.notebooksList();
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Сортировка списка ноутбуков по имени: ");
        for (String i : list)
        {
            System.out.println(i);
        }

    }

    public void mapOfNotebooks()
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);

        Map<Integer, String> notebooks = new HashMap<Integer, String>();
        Integer count = 0;
        for (String i : notebookFilterPage.notebooksList())
        {
            notebooks.put(count++, i);
        }

        System.out.println("Все записи словаря: ");
        for (Map.Entry<Integer, String> i : notebooks.entrySet())
        {
            System.out.println("Ключ: "+i.getKey()+" Значение: "+i.getValue());
        }

        System.out.println("Самое длинное значение в словаре: "+Collections.max(notebooks.values()));
    }

    public Boolean equalOfTwoNotebooks()
    {
        NotebookFilterPageObject notebookFilterPage = PageFactory.initElements(Driver.webDriver, NotebookFilterPageObject.class);
        NotebookDetailCharacteristics notebookDetailCharacteristics = PageFactory.initElements(Driver.webDriver, NotebookDetailCharacteristics.class);

        notebookFilterPage.goToNotebooksListOfElements(0);

        NotebookPower firstNotebook = new NotebookPower();
        firstNotebook = notebookDetailCharacteristics.getPowerInfo();

        CloseWindow();
        SwithcWindow(0);

        notebookFilterPage.goToNotebooksListOfElements(1);

        NotebookPower secondNotebook = new NotebookPower();
        secondNotebook = notebookDetailCharacteristics.getPowerInfo();

        popUpShowText();
        CloseWindow();
        SwithcWindow(0);

        System.out.println("Соответствие блоков 'power' двух ноутбуков: "+(firstNotebook.equals(secondNotebook)));

        return firstNotebook.equals(secondNotebook);
    }

    public void popUpShowText()
    {
        NotebookDetailCharacteristics notebookDetailCharacteristics = PageFactory.initElements(Driver.webDriver, NotebookDetailCharacteristics.class);
        System.out.println("Текст подсказки: "+notebookDetailCharacteristics.getPopUpText());
    }

}
