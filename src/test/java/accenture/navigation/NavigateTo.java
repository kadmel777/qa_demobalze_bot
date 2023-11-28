package accenture.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theDemoBlazeHomePage() {
        return Task.where("{0} opens the DemoBlaze home page",
                Open.browserOn().the(DemoBlazeGoHomePage.class));
    }
}
