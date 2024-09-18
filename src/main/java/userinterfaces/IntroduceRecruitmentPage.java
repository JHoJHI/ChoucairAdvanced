package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class IntroduceRecruitmentPage extends PageObject {
    public static final Target BUTTON_RECRUITMENT= Target.the("Botón para entrar al modulo Recruitment").locatedBy("//li[@class='oxd-main-menu-item-wrapper']//a[@href='/web/index.php/recruitment/viewRecruitmentModule' and contains(@class, 'oxd-main-menu-item')]");
    public static final Target BUTTON_ADD= Target.the("Botón para añadir un usuario").locatedBy("//button[contains(@class, 'oxd-button--secondary') and .//i[contains(@class, 'bi-plus')]]");
}
