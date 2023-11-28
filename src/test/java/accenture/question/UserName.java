package accenture.question;

import accenture.userInterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class UserName implements Question {
    Integer TIMEOUT = 30;
    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(HomePage.USER_NAME_LABEL, isPresent()).forNoMoreThan(TIMEOUT).seconds());
        return Text.of(HomePage.USER_NAME_LABEL).answeredBy(actor);
    }

public static UserName visibleOnScreen(){
        return new UserName();
}
}
