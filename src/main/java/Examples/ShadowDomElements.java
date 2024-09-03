package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElements {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
// scenario1 = page --> DOM --> ShadowDOM--> element
		Page page = browser.newPage();
//		page.navigate("https://books-pwakit.appspot.com");
//		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing books");
//		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
//		System.out.println(text);		
// scenario2 = page --> DOM -->iFrame--> ShadowDOM--> element
//		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
//		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Tea");
//		
//Scenario3 = page --> DOM --> ShadowDOM --> Iframe--> element
		page.navigate("https://selectorshub.com/iframe-in-shadow-dom/");
//		page.locator("div#userName #kils").fill("teena");
		page.locator("div#userName").frameLocator("#pact1").locator("input#glaf").fill("tbehd");
		

		
	
		
	}
}
