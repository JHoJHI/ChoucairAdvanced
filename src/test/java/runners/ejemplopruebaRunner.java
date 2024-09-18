package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//@RunWith(CucumberWithSerenity.class)

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/ejemploprueba.feature",
        glue ={"Config", "stepdefinitions"} ,
        tags = "@EscenarioInicial",
        snippets = SnippetType.CAMELCASE



)
public class ejemplopruebaRunner {
}
