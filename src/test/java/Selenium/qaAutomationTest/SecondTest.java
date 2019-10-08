package Selenium.qaAutomationTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class SecondTest {
	WebDriver driver = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFirefoxOptionsTest2() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTextInput() {
		fail("Not yet implemented");
	}

	@Test
	void testEnter() {
		fail("Not yet implemented");
	}
	@DisplayName(value = "Use JUnit assertion to compare the number of results to 777.")
	@Test
	void testTestJunit() {
		
		WebElement count = driver.findElement(By.id("resultStats"));
		
		String num = count.getText();
		String number = num;
		number = number.substring(4, 18);
		
		String numbers = number.replace(".","").trim();
		int result = Integer.parseInt(numbers);
		
		Assert.assertEquals("There is too much cheese on the internet", 777, result);
	}

}
