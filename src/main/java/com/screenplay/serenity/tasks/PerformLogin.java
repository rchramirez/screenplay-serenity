package com.screenplay.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import com.screenplay.serenity.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PerformLogin implements Task {

    private final String username;
    private final String password;

    public PerformLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static PerformLogin withCredentials(String username, String password) {
        return instrumented(PerformLogin.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
