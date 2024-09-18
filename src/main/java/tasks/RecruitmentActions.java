package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.IntroduceRecruitmentPage.*;

public class RecruitmentActions implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_RECRUITMENT),
                Click.on(BUTTON_ADD)
        );

    }

    public static RecruitmentActions addUser() {
        return instrumented(RecruitmentActions.class);
    }
}
