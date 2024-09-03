package Examples;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectorsInChromeDevTools {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	page.navigate("https://www.walmart.com/");
	int count = page.locator("a:has-text('Walmart')").count();
	System.out.println(count);
	List<String> text = page.locator("a:has-text('Walmart')").allInnerTexts();
	
////	for each loop using streams
//	text.stream().forEach(t -> System.out.println(t) );
	
	for(String l : text) {
		System.out.println(l);
	}
}
}
