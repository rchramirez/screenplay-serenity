package com.screenplay.serenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenGoogle implements Task {

    private final String url;

    public OpenGoogle(String url) {
        this.url = url;
    }

    public static OpenGoogle at(String url) {
        return instrumented(OpenGoogle.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
