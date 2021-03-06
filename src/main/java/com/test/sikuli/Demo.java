package com.test.sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Demo {

    static {
        WebDriverManager.chromedriver().setup();

    }
    static WebDriver driver = new ChromeDriver();

    private final By inputFile = By.xpath("//p[@style='margin-left:100px;']/input");
    private final By lblUploadSuccess = By.xpath("//h4[normalize-space()='File Upload Successful']");

	@Test
	public void testWithSikuli() throws FindFailed, InterruptedException {
        String workDir = System.getProperty("user.dir");

		Screen screen = new Screen();

        driver.get("http://demo.guru99.com/test/image_upload/index.php"); //Added a demo website

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(".//*[@id='photoimg']"))).click().build().perform();
        Thread.sleep(3000);
        String filePath = "C:/Users/Prasanga Fernando/Desktop/";

        Pattern openButton = new Pattern(filePath+"openButton.PNG");
        Pattern filenameField = new Pattern(filePath+"filenameField.PNG");

        screen.wait(openButton, 200); //Added 200 milliseconds wait

        String txtFile = workDir.concat("\\src\\main\\resources\\test.txt");
        screen.type(filenameField,txtFile);
        System.out.println("Txt file directory ====> "+txtFile);
        screen.click(openButton);
        Thread.sleep(5000);

	}

    @Test
    public void testWithRobotClass() throws AWTException {

        String workDir = System.getProperty("user.dir");
        String txtFile = workDir.concat("\\src\\main\\resources\\test.txt");
            //StringSelection is a class that can be used for copy and paste operations.
            StringSelection stringSelection = new StringSelection(txtFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            System.out.println("File location ===> "+txtFile);

        driver.get("http://demo.guru99.com/test/image_upload/index.php"); //Added a demo website

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(".//*[@id='photoimg']"))).click().build().perform();

        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Test
    public void testWithTraditionalWay() {

        driver.get("http://demo.guru99.com/test/image_upload/index.php"); //Added a demo website
        String workDir = System.getProperty("user.dir");
        String txtFile = workDir.concat("\\src\\main\\resources\\test.txt");
        driver.findElement(inputFile).sendKeys(txtFile);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblUploadSuccess));

    }

    @AfterMethod
    public void closeSession(){
        driver.close();
    }
	
	
	
}
