package selenuim_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum Drivers {
	WIN_CHROME("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	
	private String prop;
	private String path;
	
	private Drivers(String prop, String path) {
		this.prop = prop;
		this.path = path;
	}
	
	public String getProp() {
		return prop;
	}
	public String getPath() {
		return path;
	}
	
	public WebDriver getWebDriver() {
		System.setProperty(prop, path);
		WebDriver driver = null;
		switch (this) {
		case WIN_CHROME:{
			driver = new ChromeDriver();
			break;
		}
		default:{
			driver = null;
		}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
}
