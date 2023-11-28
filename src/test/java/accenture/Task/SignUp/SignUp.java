package accenture.Task.SignUp;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import accenture.interaction.Accept;
import accenture.userInterface.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SignUp implements Task {

    public static SignUpWith with (){
        return new SignUpWith();
    }

    private final String username;
    private final String password;

    public SignUp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.SIGN_UP_BUTTON)
               ,WaitUntil.the(HomePage.SIGN_UP_NAME_INPUT, isPresent()).forNoMoreThan(5).seconds()
               ,Enter.theValue(username).into(HomePage.SIGN_UP_NAME_INPUT)
               ,Enter.theValue(password).into(HomePage.SIGN_UP_PASSWORD_INPUT)
               ,Click.on(HomePage.SIGN_UP_FROM_BUTTON)
               ,Accept.alert()
        );
    }

    public static class SignUpWith{
        private String username;

        public SignUpWith username(String username){
            this.username = username;
            return this;
        }

        public SignUpWith and(){
            return this;
        }

        public SignUp password(String password){
            return Tasks.instrumented(SignUp.class,username,password);
        }
    }
}
