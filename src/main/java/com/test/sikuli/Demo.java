package com.test.sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Test
	public void testMethod() throws FindFailed, InterruptedException {
		Screen screen = new Screen();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/image_upload/index.php"); //Added a demo website
        
      //  Thread.sleep(5000);

        //	driver.findElement(By.xpath("//input[@id='photoimg']")).click();
      //  driver.findElement(By.xpath("//input[@type='file']")).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('photoimg').click()");
        // driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
//		String filePath = "C:/Users/Prasanga Fernando/Desktop/";
//		Screen s = new Screen();
//        Pattern openButton = new Pattern(filePath+"openButton.PNG");
//        Pattern filenameField = new Pattern(filePath+"filenameField.PNG");
//
//
//       // s.wait(openButton, 20);
//        s.type(filenameField,"diaphanous.txt");
//        s.click(openButton);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(".//*[@id='photoimg']"))).click().build().perform();
        Thread.sleep(3000);
        String filePath = "C:/Users/Prasanga Fernando/Desktop/";

        Pattern openButton = new Pattern(filePath+"openButton.PNG");
        Pattern filenameField = new Pattern(filePath+"filenameField.PNG");


       // s.wait(openButton, 20);
        screen.type(filenameField,"diaphanous.txt");
        screen.click(openButton);
	//	driver.close();
	}
	
	
	
}
