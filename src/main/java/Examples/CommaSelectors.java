package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");
//		page.locator("a.nav-link:has-text('Courses')," + "a.nav-link:has-text('Store')").click();

		Locator imp_ele = page.locator(
				"a.nav-link:has-text('Courses'),a.nav-link:has-text('Demo Site'),a:has-text('EXPLORE COURSES')");
		System.out.println(imp_ele.count());
		if (imp_ele.count() == 3) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}
}
