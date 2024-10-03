package base;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestBase {

    public static Browser browser;
    public static Page page;
    public static WebDriver driver;
    @Test
    public static void test() throws InterruptedException {
     browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext incognitoContext = browser.newContext();  // 1 Setup for page
       page = incognitoContext.newPage();
        page.setDefaultTimeout(30000); //page load timeout
        page.navigate("https://demoqa.com/alerts"); // 2 Navigate to URL
        page.click("//button[.='Click me']");
        // Approach 1
        Locator locators = page.locator("//div[contains(.,'SAMSUNG')]");
        // here locators store multiple elements
        for(int i=0;i<locators.count();i++){
            String text=locators.nth(i).innerText();
            System.out.println("Text "+i+" ="+text);
        }
        // Approach 2
        //By querySelectorALL
        List<ElementHandle> listOfElements = page.querySelectorAll("//div[contains(.,'SAMSUNG')]");
        for(ElementHandle x:listOfElements){
            String text=x.innerText();
            System.out.println("Text "+x+" ="+text);
        }


    }



@Test
void play(){
    Playwright playwright = Playwright.create();
    Browser broswer = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page pagee = broswer.newPage();
    pagee.navigate("https://facebook.com");


    }








public static void setUpDriver(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized"); // open Browser in maximized mode
    options.addArguments("--incognito");
    options.setBrowserVersion("128");
    driver=new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.switchTo().frame("w");

}
}
