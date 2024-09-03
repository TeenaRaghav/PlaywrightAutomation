package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathUnion {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");
			Locator courses =page.locator("//a[text()='Courses'] | //a[text()='Store']");
			System.out.println(courses.textContent());
			courses.click();

	}
}