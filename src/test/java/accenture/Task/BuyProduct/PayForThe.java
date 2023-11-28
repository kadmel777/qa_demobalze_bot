package accenture.Task.BuyProduct;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import accenture.interaction.Complete;
import accenture.userInterface.CartPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class PayForThe implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.CART_BUTTON)
                         ,Click.on(CartPage.PLACE_ORDER_BUTTON)
                         ,WaitUntil.the(CartPage.PURCHASE_FORM, isPresent()).forNoMoreThan(5).seconds()
                         ,Complete.placeOderForm()
                         ,Click.on(CartPage.PURCHASE_BUTTON)
                         ,WaitUntil.the(CartPage.SUCCES_PURCHASE_DIV, isPresent()).forNoMoreThan(5).seconds());
        String message = Text.of(CartPage.SUCCES_PURCHASE_DIV).answeredBy(actor);
        actor.remember("message", message);
        actor.attemptsTo(Click.on(CartPage.OK_BUTTON));
    }

    public static PayForThe cart(){
        return Tasks.instrumented(PayForThe.class);
    }
}
