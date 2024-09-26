package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.LoginPage.*;

public class IngresoLogin implements Task {


    private String username;
    private String contrasena;
    public IngresoLogin(String username, String contrasena){
        this.username = username;
        this.contrasena = contrasena;
    }

    //el override hereda al actor que se está trabajando en los steps y recibo el actor
    @Override
    public <T extends Actor> void performAs(T actor) {
        //El attempts t es el que va a realizar las acciones
        actor.attemptsTo(
                Enter.theValue(username).into(INPUT_USERNAME),
                Enter.theValue(contrasena).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN)
        );

    }
    //Es un tipo de instanciamiento que evita esto Ingresologin ingresologin = new  Ingresologin
    public static IngresoLogin conUserPsw(String usuario, String contrasena) {
        return instrumented(IngresoLogin.class,usuario,contrasena );
    }

}
