package com.test.sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Test
	public void testMethod() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/"); //Added a demo website
		
		Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern("Add filepath here");
		
	}
	
	
}
