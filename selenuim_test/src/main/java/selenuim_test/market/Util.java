package selenuim_test.market;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

public class Util {
	public static String defineOfferIdFromDataZoneData(WebElement we) {
		String text = we.getAttribute("data-zone-data");
		return defineOfferIdFromString(text);
	}
	
	public static String defineOfferIdFromString(String text) {
		String res = null;
		Pattern patter = Pattern.compile("\"offerId\":\".*?\"");
		Matcher match = patter.matcher(text);
		match.find();
		res = (text.substring(match.start(), match.end()));
		res = res.substring(10);
		res = res.replaceAll("\"", "");
		return res;
	}
}
