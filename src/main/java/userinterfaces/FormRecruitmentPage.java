package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

//Herencia
public class FormRecruitmentPage extends PageObject {

public static final Target INPUT_FIRST_NAME= Target.the("Campo para diligenciar el nombre del candidato ").located(By.name("firstName"));
    public static final Target INPUT_MIDDLE_NAME= Target.the("Campo para diligenciar el segundo nombre del candidato").located(By.name("middleName"));
    public static final Target INPUT_LAST_NAME= Target.the("Campo para diligenciar apellido del candidato").located(By.name("lastName"));
    public static final Target INPUT_EMAIL= Target.the("Campo para diligenciar email").locatedBy("//div[contains(@class, 'oxd-input-group__label-wrapper')]/following-sibling::div//input[@class='oxd-input oxd-input--active']");

    public static final Target INPUT_UPLOAD_DOC= Target.the("Campo para subir el archivo").locatedBy("//input[@type='file']");
    public static final Target INPUT_CONTACT_NUMBER= Target.the("Campo para diligenciar el número de teléfono").located(By.xpath("//label[contains(@class, 'oxd-label') and contains(text(), 'Contact')]/following::input[1]"));
    public static final Target BUTTON_SAVE= Target.the("Boton guardar").locatedBy("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and contains(@class, 'orangehrm-left-space')]");
    public static final Target BUTTON_SHORLIST= Target.the("Boton Shorlist").locatedBy("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--success')]");
    public static final Target BUTTON_SCHEDULE_INTERVIEW = Target.the("Boton scheduleinterview").located(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--success')]"));
    public static final Target INPUT_INTERVIEW_TITLE = Target.the("campo Interview Title").located(By.xpath("//label[text()='Interview Title' or text()='Título de la Entrevista']/following::input[1]"));
    public static final Target INPUT_INTERVIEWER_TITLE = Target.the("Campo Interviewer title").located(By.xpath("//label[text()='Interviewer']/following::input[1]"));
    public static final Target DATE = Target.the("Campo Date").located(By.xpath("//label[contains(text(), 'Date') or contains(text(), 'Fecha')]/following::input[1]"));
    public static final Target BUTTON_MARK_INTERVIEW_PASSED= Target.the("Boton Mark Interview passed").located(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--success')]"));
    public static final Target BUTTON_OFFER_JOB=Target.the("Boton offer job").located(By.xpath("//button[text()=' Offer Job ']"));
    public static final Target BUTTON_HIRE= Target.the("Boton Hire").located(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--success')]"));
    public static final Target SPIN_LOAD = Target.the("Spinnner loader").located(By.className("oxd-loading-spinner"));
    public static final Target INPUT_VACANCY_HIRIN = Target.the("Campo para diligenciar nombre").locatedBy("//label[text()='Vacancy']/following::p[@class='oxd-text oxd-text--p']");

}
