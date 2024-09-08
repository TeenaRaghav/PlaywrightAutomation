package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

//	text selector
		page.navigate("https://demo.opencart.com/en-gb?route=account/login");
//	page.locator("text = Contact Sales").last().click();
//	page.locator("xpath=//p[@class='privacy-policy']/a").click();
//	System.out.println(page.locator("h2:has-text('New Customer')").textContent());
//	System.out.println(page.locator("text=New Customer").textContent());
		// not working
		// System.out.println(page.locator("div.col mb-3 div.border rounded p-3 d-flex
		// flex-column h-100 h2:has-text('New Customer')").textContent());
//		String heading = page.locator("'Returning Customer'").textContent();
//		System.out.println(heading);
// button
		page.locator("form button:has-text('Login')").click();
		System.out.println("button clicked");
	}
}
