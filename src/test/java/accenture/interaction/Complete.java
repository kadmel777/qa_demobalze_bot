package accenture.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import accenture.Dto.UserPurchaseDataDto;
import accenture.userInterface.CartPage;

public class Complete implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        UserPurchaseDataDto user = new UserPurchaseDataDto();
        actor.attemptsTo(Enter.theValue(user.getName()).into(CartPage.NAME_INPUT)
                        ,Enter.theValue(user.getCountry()).into(CartPage.COUNTRY_INPUT)
                        ,Enter.theValue(user.getCity()).into(CartPage.CITY_INPUT)
                        ,Enter.theValue(user.getCreditCard()).into(CartPage.CREDIT_CARD_INPUT)
                        ,Enter.theValue(user.getMonth()).into(CartPage.MONTH_INPUT)
                        ,Enter.theValue(user.getYear()).into(CartPage.YEAR_INPUT));

    }

    public static Complete placeOderForm(){
        return Tasks.instrumented(Complete.class);
    }
}
