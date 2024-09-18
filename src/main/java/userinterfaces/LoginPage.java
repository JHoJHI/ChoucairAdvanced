package userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url")
public class LoginPage extends PageObject {

    //public static final  Target es una constante de tipo target
    // locatedBy es para xpath y located(By.) es para id y demas
    public static final Target INPUT_USERNAME= Target.the("Campo para ingresar el usuario").located(By.name("username"));
    public static final Target INPUT_PASSWORD= Target.the("Campo para ingresar la contraseña").located(By.name("password"));
    public static final Target BUTTON_LOGIN= Target.the("Botón login").located(By.xpath("//button[contains(@class, 'orangehrm-login-button')]"));

}
