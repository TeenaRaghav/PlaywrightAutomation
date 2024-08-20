package Examples;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = browser.newPage();
      page.navigate("https://playwright.dev/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
      page.pause();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Node.js")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Java").setExact(true)).click();
    }
  }
}