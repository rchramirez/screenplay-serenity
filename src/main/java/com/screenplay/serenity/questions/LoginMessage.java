package com.screenplay.serenity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class LoginMessage implements Question<String> {

    private final Target messageTarget;

    public LoginMessage(Target messageTarget) {
        this.messageTarget = messageTarget;
    }

    public static LoginMessage displayedIn(Target target) {
        return new LoginMessage(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return messageTarget.resolveFor(actor).getText();
    }
}
