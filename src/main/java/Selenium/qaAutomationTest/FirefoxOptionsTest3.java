package Selenium.qaAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit; 

public class FirefoxOptionsTest3 {
	
	WebDriver driver = null;
	public static String projectPath = System.getProperty("user.dir");
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	By result_search = By.id("resultStats");
	By link_search = By.xpath("/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/div[1]/a[1]/h3/div");
	By button_login = By.id("btnLogin");
	By btn_btn_primary_dropdown_toggle = By.id("loginAsButtonGroup");
	By selectByValue = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div/form/div[3]/div/ul/li[1]/a");
	By recruiment = By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]");
	By navigationMenu = By.xpath("/html/body/div[1]/div/div[5]/nav/div/a[1]");
	By candidate = By.xpath("/html/body/div[1]/div/div[5]/nav/ul/li[5]/a");
	By tableEmail = By.xpath("/html/body/div[1]/div/div[8]/div/div[2]/table/tbody/tr[1]/td[4]");
	By green_button = By.xpath("/html/body/div[1]/div/div[8]/div/div[1]/a/i");
	By openpanel = By.xpath("/html/body/div[1]/div/div[5]/nav/div/a[1]/i");
	
	public FirefoxOptionsTest3 (WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInput(String text) {
		driver.findElement(textbox_search).sendKeys(text);
		driver.manage().window().maximize();
	}
	
	public void enter() {
		driver.findElement(button_search).submit();
	}
	
	public void clickOnLink() {
		driver.findElement(link_search).click();
	}
	
	public void openDropdown() {
		driver.findElement(btn_btn_primary_dropdown_toggle).click();
	}
	
	public void selectElement() {
		driver.findElement(selectByValue).click();
	}
	
	public void enterLogin() {
		driver.findElement(button_login).submit();
	}
	
	public void selectRecruiment() {
		driver.findElement(recruiment).click();
	}
	
	public void selectNavigationMenu() {
		driver.switchTo().frame("noncoreIframe");
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
		driver.findElement(navigationMenu).click();		
	}
	
	public void selectCandidate() {
		driver.findElement(candidate).click();
	}
	
	public void printNumberOfCandidates() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div[8]/div/div[2]/table/tbody/tr"));
		int count = rows.size();
		System.out.println("Step 5. Print out the number of candidates: "+count);
	}
	
	public void greenButton() {
		driver.findElement(green_button).click();
	}
	
	public void fillFields() throws AWTException {
		String inputName = "QA Automation";
		String inputLastName = "Stalone";
		String inputMail = "mail@google.com";
		String inputMiddle = "Rambo";
		String inputPhone = "000666999";
		
		WebElement name = driver.findElement(By.id("addCandidate_firstName"));
		String js = "arguments[0].setAttribute('value','"+inputName+"')";
		((JavascriptExecutor) driver).executeScript(js, name);
	
		WebElement lastName = driver.findElement(By.id("addCandidate_lastName"));
		String jsLastName = "arguments[0].setAttribute('value','"+inputLastName+"')";
		((JavascriptExecutor) driver).executeScript(jsLastName, lastName);
		
		WebElement email = driver.findElement(By.id("addCandidate_email"));
		String jsEmail = "arguments[0].setAttribute('value','"+inputMail+"')";
		((JavascriptExecutor) driver).executeScript(jsEmail, email);
		
		WebElement middleName = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/label"));
		String jsMiddle = "arguments[0].setAttribute('value','"+inputMiddle+"')";
		((JavascriptExecutor) driver).executeScript(jsMiddle, middleName);
		
		WebElement phone = driver.findElement(By.id("addCandidate_contactNo"));
		String jsPhone = "arguments[0].setAttribute('value','"+inputPhone+"')";
		((JavascriptExecutor) driver).executeScript(jsPhone, phone);
		
		WebElement vacancy = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[5]/div[1]/div/label"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", vacancy);
		
		WebElement qaEng = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[5]/div[1]/div/div/ul/div/li[1]/a/p"));
		executor.executeScript("arguments[0].click();", qaEng);
		
		WebElement resume = driver.findElement(By.id("addCandidate_resume"));
		executor.executeScript("arguments[0].click();", resume);
		resume.sendKeys(projectPath+"\\pictures\\test.docx");
		
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ESCAPE);
	    robot.keyRelease(KeyEvent.VK_ESCAPE);
		WebElement save = driver.findElement(By.xpath("//*[@id=\"saveCandidateButton\"]"));
		save.click();
	}
	
//		@Test step 8. Use Junit Assert to check if the number of candidates is increased by 1. 
//	public void jUnitTest() {
//	WebElement count = driver.findElement(result_search);
//	assertEquals(777, "There is too much cheese on the internet");
//	}
		
	public void deleteCandidate() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.xpath("/html/body/div[1]/div/div[8]/div/div[2]/table/tbody/tr[1]/td[1]/label"));
		Thread.sleep(2000);
		checkBox.click();
		WebElement threeDots = driver.findElement(By.xpath("/html/body/div[1]/div/div[8]/div/div[2]/table/thead/tr/th[1]/a/i"));
		Thread.sleep(2000);
		threeDots.click();
		
		WebElement deleteCan = driver.findElement(By.xpath("//*[@id=\"deleteItemBtn\"]"));
		Thread.sleep(2000);
		deleteCan.click();
		
		WebElement confirmDelete = driver.findElement(By.xpath("//*[@id=\"candidate-delete-button\"]"));
		Thread.sleep(2000);
		confirmDelete.click();
		Thread.sleep(2000);
	}

//		@Test step 10. Use Junit Assert to check if the number of candidates is decresed by 1. 
//	public void jUnitTest() {
//	WebElement count = driver.findElement(result_search);
//	assertEquals(777, "There is too much cheese on the internet");
//	}
	
	public void logOut() throws InterruptedException {
		WebElement klik4 = driver.findElement(openpanel);
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
		klik4.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/nav/ul/a/span[3]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/nav/ul/div/div/div[3]/a")).click();
				
		System.out.println(" -end of test- ");
	
	}
}
	
	

