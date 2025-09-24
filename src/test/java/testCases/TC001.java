package testCases;

import listeners.iTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import static java.time.temporal.ChronoUnit.SECONDS;

@Listeners(iTestListener.class)
public class TC001 {

public static WebDriver driver;
@BeforeMethod
void setup(){
    ChromeOptions options = new ChromeOptions();

    // Fix for Docker/CI environments
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disable-gpu");
    options.addArguments("--headless=new"); // if you want headless mode
    options.addArguments("--user-data-dir=/tmp/chrome-user-data"); // unique dir
    driver=new ChromeDriver(options);
    System.out.println("driver setup done");
    driver.manage().timeouts().implicitlyWait(Duration.of(10,SECONDS));
}
    @Test()
    void test2() throws IOException, InterruptedException {
        //Assert.fail();

        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
//        driver.findElement(By.xpath("ede")).click();
        System.out.println("navigated to https://www.facebook.com");

    }
    @Test()
    void test3() throws IOException {
        driver.get("https://www.facebook.com");
      driver.findElement(By.xpath("edey")).click();
System.out.println("*******************");
 System.out.println(System.getProperty("server"));
        System.out.println("*******************");


}
@AfterMethod
void tearDown(){
    driver.quit();
}


}
