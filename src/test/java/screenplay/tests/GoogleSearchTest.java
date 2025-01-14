package screenplay.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.screenplay.serenity.actors.Actors;
import com.screenplay.serenity.tasks.OpenGoogle;
import com.screenplay.serenity.questions.Title;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SerenityJUnit5Extension.class)
public class GoogleSearchTest {

    @Test
    public void userCanOpenGoogleAndVerifyTitle() {
        Actor user = Actors.user();

        user.attemptsTo(OpenGoogle.at("https://www.google.com"));

        String pageTitle = user.asksFor(Title.ofThePage());
        assertEquals("Google", pageTitle);
    }
}
