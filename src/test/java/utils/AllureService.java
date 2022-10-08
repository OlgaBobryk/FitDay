package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class AllureService {

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public String getSystemName() {
        return System.getProperty("os.name");

    }
}
