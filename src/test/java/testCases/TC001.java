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

import java.io.*;
import java.util.Properties;

@Listeners(iTestListener.class)
public class TC001 extends TestBase {




    @Test()
    void test2() throws IOException {

//        driver.get("https://www.facebook.com");
//        driver.findElement(By.xpath("ede")).click();
        System.out.println("method run ***** xxxxx *****");

        Properties prop=new Properties();
        prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties"));
        System.out.println(prop.getProperty("envirnment"));



    }

    
    @Test()
    void test3() throws IOException {

//        driver.get("https://www.facebook.com");
//        driver.findElement(By.xpath("ede")).click();
        System.out.println("method run ***** xxxxx *****");

        // Properties prop=new Properties();
        // prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties"));
        // System.out.println(prop.getProperty("envirnment"));



    }



}
