package Utilities;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Functions {

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static Performable esperar(int tiempoEnMilisegundos) {
        return Task.where("{0} espera " + tiempoEnMilisegundos + " milisegundos",
                actor -> {
                    try {
                        Thread.sleep(tiempoEnMilisegundos);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
    }

    public static String generateRandomDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endOfYear = LocalDate.of(currentDate.getYear(), 12, 31);
        long randomDay = ThreadLocalRandom.current().nextLong(currentDate.toEpochDay(), endOfYear.toEpochDay() + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return randomDate.format(formatter);
    }

    public static Performable seleccionarOpcionDropdown(int cantidadArrowDowns, int dropdownIndex) {
        return Task.where("{0} selecciona la opción del dropdown número " + dropdownIndex + " usando " + cantidadArrowDowns + " flechas hacia abajo",
                actor -> {
                    // Localizar Dropdown por indice
                    Target dropdown = Target.the("dropdown número " + dropdownIndex)
                            .located(By.xpath("(//div[contains(@class, 'oxd-select-text-input')])[" + dropdownIndex + "]"));
                    actor.attemptsTo(Click.on(dropdown));
                    actor.attemptsTo(Functions.esperar(500));
                    //Repite la cantidad de veces del arow down
                    for (int i = 0; i < cantidadArrowDowns; i++) {
                        actor.attemptsTo(Hit.the(Keys.ARROW_DOWN).into(dropdown));
                    }
                    //Send keys enter
                    actor.attemptsTo(Hit.the(Keys.ENTER).into(dropdown));
                }
        );
    }

    public static String generateRandomPhoneNumber() {
        long phoneNumber = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
        return Long.toString(phoneNumber);
    }


}



