package DemoTestNG;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation_Selenium4Feature {
	ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void mockGeoLocation_executeCDPCommand() {
		Map <String, Object> coordinates = new HashMap<>();
		coordinates.put("latitude", 25.1972);
		coordinates.put("longitude", 55.2744);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand(
				"Emulation.setGeolocationOverride", coordinates);
		driver.get("https://where-am-i.org/");
	}
	
	@Test
	public void mockGeoLocation_DevTools() {
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(25.1972), Optional.of(55.2744), Optional.of(1)));
		driver.get("https://where-am-i.org/");
	}
}
