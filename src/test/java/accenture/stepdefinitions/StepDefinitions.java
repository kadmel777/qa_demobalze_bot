package accenture.stepdefinitions;

import accenture.question.UserName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import accenture.Dto.UserLoginDto;
import accenture.Task.BuyProduct.Buy;
import accenture.Task.BuyProduct.PayForThe;
import accenture.Task.SignUp.LogIn;
import accenture.Task.SignUp.SignUp;
import accenture.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {
    @Given("{actor} enters in demoblaze")
    public void camilo_enters_in_demoblaze(Actor actor) {
        actor.wasAbleTo(NavigateTo.theDemoBlazeHomePage());
    }
    @When("select the product {string} in the category {string}")
    public void select_the_product_in_the_category(String product, String category) {
        theActorInTheSpotlight().attemptsTo(
            Buy.the().product(product)
                    .inThe().Category(category)
        );
    }
    @When("go to cart and place order")
    public void go_to_cart_and_place_order() {
        theActorInTheSpotlight().attemptsTo(PayForThe.cart());
    }
    @Then("the message {string} is displayed")
    public void the_message_is_displayed(String succesMessage) {
        String actualMessage=theActorInTheSpotlight().recall("message");
        theActorInTheSpotlight().should(GivenWhenThen.seeThat("validating the successful purchase message",
                actor -> actualMessage, equalTo(succesMessage)));
    }

    @When("He enters his data in the singup and log in")
    public void he_enters_his_data_in_the_singup_and_log_in() {
        UserLoginDto user = new UserLoginDto();
        theActorInTheSpotlight().remember("userLoginData",user);
        theActorInTheSpotlight().attemptsTo(
                SignUp.with().username(user.getUsername())
                        .and().password(user.getPassword())
        );
        String messageAlert = theActorInTheSpotlight().recall("alertMessage");
        String expectedMessage="Sign up successful.";

        theActorInTheSpotlight().should(GivenWhenThen.seeThat("validating the successful sing up message",
                actor -> messageAlert, equalTo(expectedMessage)));

        theActorInTheSpotlight().attemptsTo(
                LogIn.with().username(user.getUsername())
                        .and().password(user.getPassword())
        );
    }

    @Then("username is displayed")
    public void username_is_displayed() {
        UserLoginDto user=theActorInTheSpotlight().recall("userLoginData");
        theActorInTheSpotlight().should(seeThat("The displayed user name", UserName.visibleOnScreen(), containsString(user.getUsername())));
    }
}
