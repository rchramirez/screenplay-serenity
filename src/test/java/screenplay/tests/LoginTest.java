package screenplay.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.screenplay.serenity.questions.LoginMessage;
import com.screenplay.serenity.tasks.PerformLogin;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTest {

    private Actor user;

    @BeforeEach
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        user = Actor.named("User").can(BrowseTheWeb.with(driver));
    }

    @Test
    public void userShouldLoginSuccessfully() {
        user.attemptsTo(
                PerformLogin.withCredentials("admin", "admin")
        );

        String successMessage = user.asksFor(LoginMessage.displayedIn(
                Target.the("success message").locatedBy("//div[@class='success']")
        ));

        assertEquals("Welcome, testuser!", successMessage);
    }
}
