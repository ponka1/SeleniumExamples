package selenuim_test.market;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By cartEntries = By.xpath("//div[@data-zone-name='snippet']");
	
	public ArrayList<WebElement> loadEntries() throws InterruptedException{
		Thread.sleep(5000);
		ArrayList<WebElement>list=null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		list = (ArrayList<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartEntries));
		return list;
	}
}
