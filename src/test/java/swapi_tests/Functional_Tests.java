package swapi_tests;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Functional_Tests {

	public static WebDriver driver;

	@BeforeMethod
	public void preConditions() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali Tailor\\Desktop\\jarfile\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swapi.dev/");
	}
	
	@Test
	public void search_for_a_char_validdata()
	{
		driver.findElement(By.id("interactive")).sendKeys("planets/?name=tatooine");
		driver.findElement(By.xpath("//button[contains(text(),'request')]")).click();
		boolean result=driver.findElement(By.id("interactive_output")).isDisplayed();
		Assert.assertTrue(result);
		
	}
	@Test
	public void search_for_a_char_Invaliddata()
	{
		driver.findElement(By.id("interactive")).sendKeys("people/?name=534645%$%^6l");
		driver.findElement(By.xpath("//button[contains(text(),'request')]")).click();
		boolean result=driver.findElement(By.id("interactive_output")).isDisplayed();
		Assert.assertTrue(result);
		
	}
	@Test
	public void search_for_a_char_Null()
	{
		driver.findElement(By.id("interactive")).sendKeys("");
		driver.findElement(By.xpath("//button[contains(text(),'request')]")).click();
		boolean result=driver.findElement(By.id("interactive_output")).isDisplayed();
		Assert.assertTrue(result);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
