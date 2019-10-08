package Selenium.qaAutomationTest;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

	private static WebDriver driver = null;
	public static String projectPath = System.getProperty("user.dir");

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException, IOException, ParseException, AWTException {

// all test one by one
//    	test1();
//    	test2();
//    	test3();

		
		int decision = -1;
		while (decision != 0) {
			App.ispisiMenu();

			System.out.print("options:");
			decision = ocitajCeoBroj();

			switch (decision) {
			case 0:
				System.out.println("exit app");
				break;
			case 1:
				test1();
				break;
			case 2:
				test2();
				break;
			case 3:
				test3();
				break;
			default:
				System.out.println("unknown command");
				break;
			}
		}
	}

	public static void ispisiMenu() {
		System.out.println("QA Automation test - Basic options:");
		System.out.println("\tTest no 1 - 1. Test");
		System.out.println("\tTest no 2 - 2. Test");
		System.out.println("\tTest no 3 - 3. Test");
		System.out.println("\t\t ...");
		System.out.println("\tOption no. 0 - EXIT");
	}

	public static int ocitajCeoBroj() {
		while (sc.hasNextInt() == false) {
			System.out.println("Misstake - Wrong enter , try again: ");
			sc.nextLine();
		}
		int ceoBroj = sc.nextInt();
		sc.nextLine();
		return ceoBroj;
	}

	public static void test1() throws InterruptedException, IOException, ParseException {

		System.out.println("projectPath :" + projectPath);

		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		FirefoxOptionsTest1 obj = new FirefoxOptionsTest1(driver);

		// Open Firefox brwoser and we send home page google
		driver.get("https://www.google.com");

		// In search field input wedoqa.com
		obj.setTextInput("wedoqa.com");

		// Hit button enter on search button
		obj.enter();

		// Take sleep 3s my net sometime is slow
		Thread.sleep(3000);

		// Click on first link
		obj.clickOnLink();

		// Print the testimonials from above to console
		// Find testimonials Eversave
		Thread.sleep(3000);
		obj.findTestimonials();
		Thread.sleep(1000);

		// Take a picture
		obj.screenShoot("Eversave");

		// Print the testimonials from above to console
		// Find testimonials Simplymap
		obj.findTestimonialsSimply();
		Thread.sleep(1000);

		// Print the testimonials from above to console
		// Take a picture
		obj.screenShoot("Simplymap");

		// Find testimonials PatternPublishing
		obj.findTestimonialsPatternPublishing();
		Thread.sleep(1000);

		// Take a picture
		obj.screenShoot("PatternPublishing");

		// Count the appearance of the letters ‘T’ and ‘t’ in all of the team members
		// names (First name, Last name)
		obj.counter();

		// Counter char t ant T and print out the sum.
		obj.counterAll();

		// Open blog
		obj.clickOnBlog();
		Thread.sleep(1000);

		// Take a picture
		obj.screenShoot("blog");

		// In search field input test
		obj.setTextInputBlog("test");

		// Hit button enter
		obj.enterOn();

		// Date
		obj.compareDate();

		System.out.println("");

	}

	public static void test2() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		FirefoxOptionsTest2 obj = new FirefoxOptionsTest2(driver);

		// open Firefox brwoser and home page google
		driver.get("https://www.google.com");

		// in search field input wedoqa.com
		obj.setTextInput("cheese");

		// on button enter
		obj.enter();

		// take sleep 3s
		Thread.sleep(3000);

		// take number of results to and compare to 777
		obj.testJunit();
		
		System.out.println("");

	}

	public static void test3() throws InterruptedException, AWTException {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		FirefoxOptionsTest3 obj = new FirefoxOptionsTest3(driver);

		// open Firefox brwoser and home page google
		driver.get("https://www.google.com");

		// in search field input wedoqa.com
		obj.setTextInput("https://orangehrm-demo-6x.orangehrmlive.com");

		// on button enter
		obj.enter();

		// take sleep 3s
		Thread.sleep(3000);

		// click on first link
		obj.clickOnLink();

		Thread.sleep(5000);

		// open dropdown
		obj.openDropdown();

		// chose admin Login with admin credentials (form is prefilled with the login
		// data)
		obj.selectElement();

		// submit
		obj.enterLogin();

		// chose recruiment
		Thread.sleep(15000);
		obj.selectRecruiment();

		// nav menu
		Thread.sleep(15000);
		obj.selectNavigationMenu();

		// select form menu candidate
		Thread.sleep(5000);
		obj.selectCandidate();

		// print number of candidates
		obj.printNumberOfCandidates();

		// green button Add candidate
// 		Fill the mandatory fields, the candidate name should be QA Automation -<CurrentDate>
// 		(Please substitute the current date with the current date)
//    	BUG i need to fill all fields and upload the file and then candiddate will be saved
		obj.greenButton();

		// fill fields
		obj.fillFields();
		
		//delete candidate Select the freshly created candidate and delete
		obj.deleteCandidate();
		
		//log out
		obj.logOut();
		
		System.out.println("");

	}
}
