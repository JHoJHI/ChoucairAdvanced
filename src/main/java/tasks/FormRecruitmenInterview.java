package tasks;


import Utilities.Functions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.core.Is;


import static Utilities.Functions.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.openqa.selenium.Keys.*;
import static userinterfaces.FormRecruitmentPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FormRecruitmenInterview implements Task {

 private final String randomText;
 private final String ValueInitial;
 private final String Randomdate;


    public FormRecruitmenInterview(String randomText, String ValueInitial, String Randomdate){
     this.randomText = randomText;
     this.ValueInitial=ValueInitial;
     this.Randomdate=Randomdate;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(INPUT_INTERVIEW_TITLE),
                Enter.theValue(randomText).into(INPUT_INTERVIEW_TITLE),
                Enter.theValue(ValueInitial).into(INPUT_INTERVIEWER_TITLE),
                Task.where("{0} espera 3 segundos  a que aparezca las opciones",
                Functions.esperar(3000)
                ),
                Hit.the(ARROW_DOWN).into(INPUT_INTERVIEWER_TITLE),
                Hit.the(ENTER).into(INPUT_INTERVIEWER_TITLE),
                Enter.theValue(Randomdate).into(DATE),
                Scroll.to(BUTTON_SAVE),
                Click.on(BUTTON_SAVE),
                WaitUntil.the(BUTTON_MARK_INTERVIEW_PASSED, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(BUTTON_MARK_INTERVIEW_PASSED),
                Scroll.to(BUTTON_SAVE),
                Click.on(BUTTON_SAVE),
                WaitUntil.the(BUTTON_OFFER_JOB, isPresent()).forNoMoreThan(20).seconds(),
                Click.on(BUTTON_OFFER_JOB),
                WaitUntil.the(BUTTON_SAVE, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BUTTON_SAVE),
                WaitUntil.the(BUTTON_HIRE, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BUTTON_HIRE),
                WaitUntil.the(BUTTON_SAVE, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BUTTON_SAVE),
               // WaitUntil.the(SPIN_LOAD, isNotVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(INPUT_VACANCY_HIRIN, isClickable()).forNoMoreThan(20).seconds()
        );
    }

    public static FormRecruitmenInterview dataInter() {
        String randomText = generateRandomString(5);
        String ValueInitial ="R";
        String Randomdate= generateRandomDate();
        return instrumented(FormRecruitmenInterview.class, randomText, ValueInitial, Randomdate );
    };


}

