package listeners;

import base.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class iTestListener extends TestBase implements org.testng.ITestListener  {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        getScreenShot();

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
    public static void getScreenShot() {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File f = scrShot.getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot " + getTimeStamp(), FileUtils.openInputStream(f));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        return timeStamp;
    }
}
