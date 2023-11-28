package accenture.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Accept implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait( BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String message =  BrowseTheWeb.as(actor).getDriver().switchTo().alert().getText();
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        BrowseTheWeb.as(actor).getDriver().switchTo().defaultContent();
        actor.remember("alertMessage",message);
    }

    public static Accept alert(){
        return Tasks.instrumented(Accept.class);
    }
}
