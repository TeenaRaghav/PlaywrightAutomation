package Examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsPopUpAlert {
public static void main(String[] args) throws InterruptedException {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	
//	this is the listener entry created along with the page whenever the alert is coming it will capture the alert 
//	and it will accept it also automatically.
	page.onDialog(dialog ->{
		String text = dialog.message();
		System.out.println(text);
//		dialog.accept();
//		to enter the text in the prompt
		dialog.accept("this is teena");
	});
	
	
	page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
	page.locator("//button[text()='Click for JS Alert']").click();
	String result =page.textContent("#result");
	System.out.println(result);

	
	page.locator("//button[text()='Click for JS Confirm']").click();
	System.out.println(result);


	page.locator("//button[text()='Click for JS Prompt']").click();
	System.out.println(result);
	
	
	
	
	
	
	page.close();
	browser.close();
	playwright.close();
}
}
