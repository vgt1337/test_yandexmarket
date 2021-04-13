package org.tn.Methods;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.tn.Settings.Driver;
import java.io.File;
import java.io.IOException;


public class AllureAttachment
{
    public static void addActionDescription(String action)
    {
        Allure.addAttachment(action, "");
        System.out.println(action);
    }

    public static void addScreenshot()
    {
        File tempFile = ((TakesScreenshot)Driver.webDriver).getScreenshotAs(OutputType.FILE);
        try
        {
            Allure.addAttachment("Скриншот", FileUtils.openInputStream(tempFile));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        tempFile.delete();
    }
}
