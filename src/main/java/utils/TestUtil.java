package utils;

import base.TestBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static base.TestBase.page;

public class TestUtil {

    public static void click(String locator){
        page.waitForSelector(locator,new Page.WaitForSelectorOptions().setTimeout(15000));
        page.click(locator);

    }
    public static void  fill(String locator,String value){
        page.waitForSelector(locator,new Page.WaitForSelectorOptions().setTimeout(15000));
        page.fill(locator,value);

}

}
