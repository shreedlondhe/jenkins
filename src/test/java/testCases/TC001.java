package testCases;
import base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import listeners.iTestListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Listeners(iTestListener.class)
public class TC001 extends TestBase {




    @Test()
    void test2() throws IOException {

//        driver.get("https://www.facebook.com");
//        driver.findElement(By.xpath("ede")).click();
        System.out.println("method run ***** xxxxx *****");




    }



}
