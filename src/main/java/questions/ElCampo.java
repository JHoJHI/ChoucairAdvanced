package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElCampo implements Question<Boolean> {
    private final Target campo;
    private final String textoEsperado;

    // Constructor público
    public ElCampo(Target campo, String textoEsperado) {
        this.campo = campo;
        this.textoEsperado = textoEsperado;
    }

    public static ElCampo esVisibleYContieneTexto(Target campo, String textoEsperado) {
        return new ElCampo(campo, textoEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return campo.resolveFor(actor).isVisible() && campo.resolveFor(actor).getText().contains(textoEsperado);
    }
}
