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

public class LogIn implements Task {

    public static LogInWith with(){
        return new LogInWith();
    }

    private final String username;
    private final String password;

    public LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.LOG_IN_BUTTON)
                ,WaitUntil.the(HomePage.LOG_IN_NAME_INPUT, isPresent()).forNoMoreThan(5).seconds()
                ,Enter.theValue(username).into(HomePage.LOG_IN_NAME_INPUT)
                ,Enter.theValue(password).into(HomePage.LOG_IN_PASSWORD_INPUT)
                ,Click.on(HomePage.LOG_IN_FORM_BUTTON)
        );
    }

    public static class LogInWith{
        private String username;

        public LogInWith username(String username){
            this.username=username;
            return this;
        }

        public LogInWith and(){
            return this;
        }

        public LogIn password(String password){
            return Tasks.instrumented(LogIn.class,username,password);
        }

    }
}
