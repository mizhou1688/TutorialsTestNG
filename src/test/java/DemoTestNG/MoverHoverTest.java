package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoverHoverTest {
	WebDriver driver;

	@BeforeMethod
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
	}
	
	@Test
	public void testMoveHover() {
		Actions actions = new Actions(driver);
		
		WebElement mainmenu = driver.findElement(By.id("products-dd-toggle"));
		actions.moveToElement(mainmenu);
		
		WebElement submenu = driver.findElement(By.xpath("//a[@title='Live']/div[@class='item-desc']"));
		actions.moveToElement(submenu);
		
		actions.click().build().perform();
	}
	
}
