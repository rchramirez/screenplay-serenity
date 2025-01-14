package com.screenplay.serenity.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("username field")
            .located(By.id("#loginusername"));

    public static final Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("#loginpassword"); // Selector por XPath

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("#login2"); // Selector por XPath

    public static final Target LOGIN_BUTTON_DIALOG = Target.the("login button")
            .locatedBy("//*[@onclick='logIn()']"); // Selector por XPath

}
