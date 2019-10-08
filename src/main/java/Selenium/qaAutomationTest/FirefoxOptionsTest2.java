package Selenium.qaAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirefoxOptionsTest2 {
	
	WebDriver driver = null;
	
	public static String projectPath = System.getProperty("user.dir");
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	By result_search = By.id("resultStats");
	
	public FirefoxOptionsTest2 (WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInput(String text) {
		driver.findElement(textbox_search).sendKeys(text);
		driver.manage().window().maximize();
	}
	
	public void enter() {
		driver.findElement(button_search).submit();
	}
	
	public void testJunit() {
		WebElement count = driver.findElement(result_search);
		
		String num = count.getText();
		String number = num;
		number = number.substring(4, 18);
		
		String numbers = number.replace(".","").trim();
		int result = Integer.parseInt(numbers);
		System.out.println("Number of resault> "+result);
		
		System.out.println(" -end of test- ");	
	}
	
	

	
}
