package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class GenericUtility {
    private WebDriver driver;
    private static int pageTimeout = Integer.parseInt(readConfigs("pageTimeout"));
    private static int elementTimeout = Integer.parseInt(readConfigs("elementTimeout"));

    public GenericUtility(){
        driver = DriverFactory.getWebDriver();
    }

    public static String readConfigs(String property) {
        String propValue=null;
        try {
            Properties props = new Properties();
            File fs = new File(new File("src"), "/test/resources/Config.properties");
            FileInputStream fis = new FileInputStream(fs.getAbsoluteFile());
            props.load(fis);
            propValue = props.getProperty(property);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propValue;
    }

    public void waitForPageLoad(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, pageTimeout);
            wait.until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void waitForElementToBePresent (WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, elementTimeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectDropdownOption(WebElement webelement, String dropdownOption){
        try {
            Select sel = new Select(webelement);
            sel.selectByVisibleText(dropdownOption);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}

