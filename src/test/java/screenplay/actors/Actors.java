package screenplay.actors;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actors {
    public static Actor user() {
        WebDriver driver = new ChromeDriver();
        return Actor.named("User").can(BrowseTheWeb.with(driver));
    }
}
