package tasks;

import Utilities.ConfigUtils;
import Utilities.Functions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.nio.file.Path;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static userinterfaces.FormRecruitmentPage.*;

public class FormRecruitment implements Task{

    private final String name;
    private final String secondname;
    private final String surname;
    private final String Email;
    private final String randomName;
    private final String randomDate;
    private final String randomNumber;

    public FormRecruitment(String name, String secondname, String surname, String Email, String randomName, String randomDate, String randomNumber){
        this.name =name;
        this.secondname =secondname;
        this.surname =surname;
        this.Email = Email;
        this.randomName = randomName;
        this.randomDate = randomDate;
        this.randomNumber =randomNumber;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        Path fileToUpload= ConfigUtils.getFileToUploadPath();
        actor.attemptsTo(
                Enter.theValue(name).into(INPUT_FIRST_NAME),
                Enter.theValue(secondname).into(INPUT_MIDDLE_NAME),
                Enter.theValue(surname).into(INPUT_LAST_NAME),
                Enter.theValue(Email).into(INPUT_EMAIL),
                //Enter.theValue(randomName).into(INPUT_FIRST_NAME),
                //Functions.esperar(2000),
                Functions.seleccionarOpcionDropdown(2,1),
//                Upload.theFile(fileToUpload).to(INPUT_UPLOAD_DOC)
                Task.where("{0} sube el archivo al campo de carga",
                        Upload.theFile(fileToUpload).to(INPUT_UPLOAD_DOC)
                ),
                Enter.theValue(randomNumber).into(INPUT_CONTACT_NUMBER),
                Scroll.to(BUTTON_SAVE),
                Click.on(BUTTON_SAVE),
                WaitUntil.the(BUTTON_SHORLIST, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(BUTTON_SHORLIST),
                WaitUntil.the(BUTTON_SAVE, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BUTTON_SAVE),
                WaitUntil.the(BUTTON_SCHEDULE_INTERVIEW, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(BUTTON_SCHEDULE_INTERVIEW)

        );
    }

    public static FormRecruitment datosIniciales(String name, String secondname, String surname, String Email){
        String randonName= Functions.generateRandomString(5);
        String randomDate= Functions.generateRandomDate();
        String randomNumber = Functions.generateRandomPhoneNumber();
        return instrumented(FormRecruitment.class,name,secondname,surname,Email, randonName,randomDate,randomNumber);
    };
}
