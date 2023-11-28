package accenture.Task.BuyProduct;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import accenture.interaction.Accept;
import accenture.userInterface.HomePage;
import accenture.userInterface.ProductDetailsPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class Buy implements Task {

    private final String product;
    private final String category;

    public Buy(String product, String category) {
        this.product = product;
        this.category = category;
    }

    public static BuyThe the(){
        return new BuyThe();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomePage.HOME_BUTTON)
                        ,Click.on(HomePage.CATEGORY_BUTTON.of(category))
                        ,WaitUntil.the(HomePage.PRODUCT_ITEM_CARD.of(product), isPresent()).forNoMoreThan(5).seconds()
                        ,Click.on(HomePage.PRODUCT_ITEM_CARD.of(product))
                        ,Click.on(ProductDetailsPage.ADD_CART_BUTTON)
                        ,Accept.alert());
    }

    public static class BuyThe {
        private String product;

        public BuyThe product(String product){
            this.product = product;
            return this;
        }

        public BuyThe inThe(){
            return this;
        }

        public Buy Category(String category){
            return Tasks.instrumented(Buy.class,product,category);
        }

    }
}
