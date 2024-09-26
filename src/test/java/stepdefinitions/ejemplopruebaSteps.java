package stepdefinitions;

import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.actions.Open;


import questions.ElCampo;
import tasks.*;
import userinterfaces.LoginPage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static userinterfaces.FormRecruitmentPage.INPUT_VACANCY_HIRIN;


public class ejemplopruebaSteps {


    private final LoginPage loginPage = new LoginPage();

    @Given("^Un reclutador (.*) accede hasta el modulo recruitment con usuario (.*) y contraseña (.*)$")
    public void unReclutadorAccedeHastaElModuloRecruitment(String Actorname, String usuario, String contrasena) {
     theActorCalled(Actorname).wasAbleTo(Open.browserOn(loginPage));
     getDriver().manage().window().maximize();
     theActorInTheSpotlight().wasAbleTo(
     IngresoLogin.conUserPsw(usuario, contrasena),
     RecruitmentActions.addUser()
    );


    }


    @When("^Se anade un nuevo usuario y se realiza el proceso de contratacion$")
    public void seAnadeUnNuevoUsuarioYSeRealizaElProcesoDeContratacion(List<String> datos) {
        theActorInTheSpotlight().wasAbleTo(
                FormRecruitment.datosIniciales(datos.get(0), datos.get(1), datos.get(2), datos.get(3)),
                FormRecruitmenInterview.dataInter()

        );
    }


    @Then("^Se valida todos los datos diligenciados en el formulario$")
    public void seValidaTodosLosDatosDiligenciadosEnElFormulario() {
        theActorInTheSpotlight().should(
         seeThat(the(INPUT_VACANCY_HIRIN), isPresent()),
         seeThat(the(INPUT_VACANCY_HIRIN), containsText("Payroll Administrator"))
         //seeThat(the(INPUT_VACANCY_HIRIN), isEnabled())
        );
//        theActorInTheSpotlight().should(
//                seeThat("El campo 'Vacancy Hiring' es visible y contiene el texto esperado",
//                        ElCampo.esVisibleYContieneTexto(INPUT_VACANCY_HIRIN, "Payroll Administrator"))
////                seeThat("El campo 'Vacancy Hiring' es visible y contiene el texto esperado",
////                        ElCampo.esVisibleYContieneTexto(INPUT_VACANCY_HIRIN, "Payroll Administrator"))
//
//        );
    }

}
