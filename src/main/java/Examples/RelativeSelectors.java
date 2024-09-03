package Examples;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeSelectors {
	static Page page;

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate(" https://selectorshub.com/xpath-practice-page/");

//left-of
//		Locator checkBox = page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first();
//		checkBox.click();
		selectUser("Joe.Root");
		selectUser("Jasmine.Morgan");
//	right-of	
//		String userRole=page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
//		System.out.println(userRole);
		findUserRole("Joe.Root");
		findUserRole("Jasmine.Morgan");

//above
		String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
		System.out.println(aboveUser);

// below
		String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
		System.out.println(belowUser);

//near with pixels 
		Locator nearElements = page.locator("td:near(:text('Joe.Root'), 400)");
		List<String> nearEleText= nearElements.allInnerTexts();
		for(String e :nearEleText ) {
			System.out.println(e);
		}
	}

	public static void selectUser(String userName) {
		page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
	}

	public static void findUserRole(String userName) {
		String userRole = page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
		System.out.println(userRole);
	}

}
