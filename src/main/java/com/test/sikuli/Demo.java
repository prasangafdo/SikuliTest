package com.test.sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Demo {

    static {
        WebDriverManager.chromedriver().setup();

    }
    static WebDriver driver = new ChromeDriver();

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
    public void testWithRobotClass(){


            //StringSelection is a class that can be used for copy and paste operations.
            StringSelection stringSelection = new StringSelection("file path");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);


    }

    @AfterMethod
    public void closeSession(){
        driver.close();
    }
	
	
	
}
