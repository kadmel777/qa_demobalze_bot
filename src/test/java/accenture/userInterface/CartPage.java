package accenture.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static Target CART_BUTTON = Target.the("Cart button").locatedBy("//a[contains(text(),'Cart')]");
    public static Target PLACE_ORDER_BUTTON = Target.the("Place order button").locatedBy("//button[@class='btn btn-success']");

    public static Target NAME_INPUT = Target.the("Name input").locatedBy("//input[@id='name']");
    public static Target COUNTRY_INPUT = Target.the("Country input").locatedBy("//input[@id='country']");
    public static Target CITY_INPUT = Target.the("City input").locatedBy("//input[@id='city']");
    public static Target CREDIT_CARD_INPUT = Target.the("Credit card input").locatedBy("//input[@id='card']");
    public static Target MONTH_INPUT = Target.the("Moth input").locatedBy("//input[@id='month']");
    public static Target YEAR_INPUT = Target.the("Year input").locatedBy("//input[@id='year']");
    public static Target PURCHASE_FORM = Target.the("Purcharse form").locatedBy("//div[@id='orderModal']");
    public static Target PURCHASE_BUTTON = Target.the("Purcharse input").locatedBy("//div[@id='orderModal']//button[@class='btn btn-primary']");
    public static Target SUCCES_PURCHASE_DIV = Target.the("Purcharse input").locatedBy("//div[@class='sweet-alert  showSweetAlert visible']//h2");
    public static Target OK_BUTTON = Target.the("Ok button").locatedBy("//button[@class='confirm btn btn-lg btn-primary']");

}
