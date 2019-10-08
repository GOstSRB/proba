package Selenium.qaAutomationTest;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class FirefoxOptionsTest1 {
	WebDriver driver = null;
	public static String projectPath = System.getProperty("user.dir");
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	By link_search = By.xpath("/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/div[1]/a[1]/h3/div");
	By testimonials = By.id("testimonials");
	By eversave = By.xpath("/html/body/section[3]/div[2]/div/div/div/div/div[1]/div/div[21]/div/div/div[3]/h6");
	By eversaveTe = By.xpath("/html/body/section[3]/div[2]/div/div/div/div/div[1]/div/div[21]/div/div/div[2]/blockquote/q");
	By simplymap = By.xpath("/html/body/section[3]/div[2]/div/div/div/div/div[1]/div/div[7]/div/div/div[3]/h6");
	By simplymapTe = By.xpath("/html/body/section[3]/div[2]/div/div/div/div/div[1]/div/div[7]/div/div/div[2]/blockquote/q");
	By patternPublishing = By.xpath("/html/body/section[3]/div[2]/div/div/div/div/div[1]/div/div[11]/div/div/div[3]/h6");
	By patternPublishingTe = By.xpath("/html/body/section[3]/div[2]/div/div/div/div/div[1]/div/div[11]/div/div/div[2]/blockquote/q");
	By teamSection = By.id("team");
	By blog = By.id("menu-item-3127");
	By textbox_search_blog = By.name("s");
	By lastDate = By.xpath("/html/body/div[1]/div/div[1]/section/article[1]/div[1]/span[2]/time");
 	
	public FirefoxOptionsTest1 (WebDriver driver) {
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

	public void findTestimonials() {
		driver.findElement(testimonials).click();
		driver.findElement(eversave).click();
		String text1 = driver.findElement(eversaveTe).getText();
		System.out.println("Testimonial text: "+text1);
	}
	
	public void findTestimonialsSimply() {
		driver.findElement(simplymap).click();
		String text2 = driver.findElement(simplymapTe).getText();
		System.out.println("Testimonial text: "+text2);
	}
	
	public void findTestimonialsPatternPublishing() {
		driver.findElement(patternPublishing).click();
		String text3 = driver.findElement(patternPublishingTe).getText();
		System.out.println("Testimonial text: "+text3);
	}
	
	public void screenShoot(String pic) throws IOException {
		File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File(projectPath+"\\pictures\\"+pic+".png"));
	}
	
	// names and T or t
	public void counter() {
		List<WebElement> list=driver.findElements(By.xpath(".//*[@class='person-content']/h6"));
			
		int rb=0;
	
		Iterator <WebElement> i1 = list.iterator();
				
		while(i1.hasNext()) {
			WebElement element = i1.next();
			String name = element.getText();
			
			long t = name.chars().filter(ch -> ch =='t').count();
			long T = name.chars().filter(ch -> ch =='T').count();
		
			rb++;
			System.out.println(rb+". "+name+"....t = "+t+"....T = "+T);
			}
		
	}
	// counter all t and T
	public void counterAll() {
		List<WebElement> list=driver.findElements(By.xpath(".//*[@class='person-content']/h6"));
		ArrayList<String> names = new ArrayList<String>();
		int sum = 0;		
		
		Iterator <WebElement> i1 = list.iterator();
		while(i1.hasNext()) {
			WebElement element = i1.next();
			names.add(element.getText());
			}
		
		for (int i = 0; i < names.size(); i++) {
			String oneName = names.get(i);
			
			for(int j = 0; j< oneName.length()-1; j++) {
				
				char [] provera = oneName.toCharArray();
					if(provera[j] == 't') {
						sum++;
					} else if (provera[j] == 'T') {
						sum++;
					}
				}
			}
		
		System.out.println("Total sum of char t = "+sum);

	}
	public void clickOnBlog() {
		driver.findElement(blog).click();
	}
	
	public void setTextInputBlog(String text) {
		driver.findElement(textbox_search_blog).sendKeys(text);
	}
	
	public void enterOn() {
		driver.findElement(textbox_search_blog).submit();
	}
	
	public void compareDate() throws ParseException {
   		Date curentTime = new Date();
        WebElement dateFromPage = driver.findElement(lastDate);
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
        String datum = dateFromPage.getAttribute("datetime");
 		Date yearStartTime = input.parse(datum);
 		long msTimeDiference = curentTime.getTime() - yearStartTime.getTime();
 		long msDay = 24 * 60 * 60 * 1000;
 		int dayCount = (int) (msTimeDiference / msDay);

 		System.out.println("How much days have passed since last entry: " +dayCount);
 		System.out.println(" -end of test- ");
		}	
	
	}

