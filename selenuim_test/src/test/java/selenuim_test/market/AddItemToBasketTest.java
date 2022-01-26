package selenuim_test.market;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenuim_test.Drivers;
import selenuim_test.market.SearchPage.ArticleElement;

public class AddItemToBasketTest {
	
	
	@Test
	public void addItem() throws InterruptedException {
		WebDriver driver = Drivers.WIN_CHROME.getWebDriver();
		
		driver.navigate().to("https://market.yandex.ru/");
		MarketPage market = new MarketPage(driver);
		SearchPage search = market.searchText("компьютер");
		
		ArrayList<ArticleElement> articles = search.loadArticles();
		ArticleElement first = articles.get(0);
		first.addInCart();
		
		search.goToCartAfterAdd();
		
		CartPage cartPage = new CartPage(driver);
		WebElement target = null;
		for (WebElement we: cartPage.loadEntries()) {
			String ofIdE = Util.defineOfferIdFromDataZoneData(we);
			if (first.getOfferId().equals(ofIdE)) {
				target = we;
				break;
			}
		}
		if (target==null) {
			fail("Desired item missing in the cart!");
			return;
		}
		driver.close();
	}
}
