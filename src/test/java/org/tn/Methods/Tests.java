package org.tn.Methods;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.tn.PageObject.ComputerTechnologyPageObject;
import org.tn.PageObject.NotebookDetailCharacteristics;
import org.tn.PageObject.NotebookFilterPageObject;
import org.tn.PageObject.StartPageObject;
import org.tn.Settings.Driver;
import org.tn.Settings.NotebookPower;
import org.tn.Settings.TestSettings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.*;

import static org.tn.Methods.AllureAttachment.addScreenshot;

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
        addScreenshot();
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
        notebookFilterPage.applyPriceQueue("high");
        if (notebookFilterPage.checkLoading()==true)
            {
                firstNotebookName=notebookFilterPage.getNameFirstNotebook();
                firstNotebookPrice=notebookFilterPage.getPriceFirstNotebook().substring(0, notebookFilterPage.getPriceFirstNotebook().length()-1);
            }
        notebookFilterPage.applyPriceQueue("low");
        if (notebookFilterPage.checkLoading()==true)
            {
                secondNotebookName=notebookFilterPage.getNameFirstNotebook();
                secondNotebookPrice=notebookFilterPage.getPriceFirstNotebook().substring(0, notebookFilterPage.getPriceFirstNotebook().length()-1);
            }

        System.out.println("Самый дорогой ноутбук: "+firstNotebookName+" его цена: "+firstNotebookPrice);
        System.out.println("Самый дешевый ноутбук: "+secondNotebookName+" его цена: "+secondNotebookPrice);
        System.out.println("Разница в цене: "+(Integer.parseInt(firstNotebookPrice.replaceAll("\\s+","")) - Integer.parseInt(secondNotebookPrice.replaceAll("\\s+",""))));
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

    public void parseJson()
    {
        String filePath = "C:\\Users\\vgt_\\IdeaProjects\\test_yandexmarket\\src\\test\\java\\org\\tn\\Settings\\json.json";
        System.out.println("Парсинг JSON");
        try
        {
            ArrayList<String> checkDoubles = new ArrayList<String>();
            Integer count = 0;
            int duplicates = 0;

            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray lang= (JSONArray) jsonObject.get("data");

            Iterator i = lang.iterator();

            while (i.hasNext())
            {
                JSONObject innerObj = (JSONObject) i.next();
                checkDoubles.add(innerObj.get("surname") + " " + innerObj.get("name")+ " " + innerObj.get("patronymic"));
                count++;
            }

            System.out.println("Значения после парсинга:");

            for(String a : checkDoubles)
            {
                System.out.println(a);
            }

            for(int c=0; c<checkDoubles.size(); c++)
            {
                for(int d=c+1; d<checkDoubles.size(); d++)
                {
                    if (checkDoubles.get(d).equals(checkDoubles.get(c)))
                    {
                        duplicates++;

                    }
                }
            }
            System.out.println("Кол-во дублей: "+duplicates);

           Collections.sort(checkDoubles);
           System.out.println("Значения после сортировки:");
            for(String a : checkDoubles)
            {
                System.out.println(a);
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
    }

    public void parseXML()
    {
        int duplicates = 0;
        Map<Integer, String> phonebook = new HashMap<Integer, String>();
        try {

            File file = new File("C:\\Users\\vgt_\\IdeaProjects\\test_yandexmarket\\src\\test\\java\\org\\tn\\Settings\\xml.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("phone");

            System.out.println("Парсинг XML");
            System.out.println("Значения после парсинга:");
            for (int s = 0; s < nodeLst.getLength(); s++)
            {
                   Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element fstElmnt = (Element) fstNode;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("number");
                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();

                    phonebook.put(Integer.parseInt(fstNmElmnt.getAttribute("id")), ((Node) fstNm.item(0)).getNodeValue());
                }
            }

            for (var i : phonebook.entrySet())
            {
                System.out.println("Ключ: "+i.getKey()+" Значение: "+i.getValue());
            }

            for(int c=0; c<phonebook.size(); c++)
            {
                for(int d=c+1; d<phonebook.size(); d++)
                {
                    if (phonebook.get(d).equals(phonebook.get(c)))
                    {
                        duplicates++;

                    }
                }
            }
            System.out.println("Кол-во дублей: "+duplicates);

            System.out.println("Значения после сортировки по значению:");
            phonebook.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByValue()).forEach(System.out::println);

        }
        catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void parseExcel()
    {
        System.out.println("Парсинг Excel");
        ArrayList<String> checkDoubles = new ArrayList<String>();

        int duplicates = 0;
        String result = "";
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try
        {
            inputStream = new FileInputStream("C:\\Users\\vgt_\\IdeaProjects\\test_yandexmarket\\src\\test\\java\\org\\tn\\Settings\\excel.xlsx");
            workBook = new XSSFWorkbook(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext())
        {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext())
            {
                Cell cell = cells.next();
                if(cell.getCellType()== CellType.STRING)
                {
                    result += cell.getStringCellValue()+" ";
                }
            }
            checkDoubles.add(result);
            result="";
        }

        System.out.println("Значения после парсинга:");
        for(String a : checkDoubles)
        {
            System.out.println(a);
        }

        for(int c=0; c<checkDoubles.size(); c++)
        {
            for(int d=c+1; d<checkDoubles.size(); d++)
            {
                if (checkDoubles.get(d).equals(checkDoubles.get(c)))
                {
                    duplicates++;

                }
            }
        }
        System.out.println("Кол-во дублей: "+duplicates);

        Collections.sort(checkDoubles);
        System.out.println("Значения после сортировки:");
        for(String a : checkDoubles)
        {
            System.out.println(a);
        }
    }
}
