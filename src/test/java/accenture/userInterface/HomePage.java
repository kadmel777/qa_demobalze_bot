package accenture.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static Target HOME_BUTTON = Target.the("Home button").locatedBy("//a[contains(text(),'Home')]");
    public static Target SIGN_UP_BUTTON = Target.the("Sign up button").locatedBy("//a[contains(text(),'Sign')]");
    public static Target LOG_IN_BUTTON = Target.the("Log in button").locatedBy("//a[contains(text(),'Log in')]");
    public static Target LOG_IN_NAME_INPUT = Target.the("Log in name input").locatedBy("//input[@id='loginusername']");
    public static Target LOG_IN_PASSWORD_INPUT = Target.the("Log in password input").locatedBy("//input[@id='loginpassword']");
    public static Target LOG_IN_FORM_BUTTON = Target.the("Log in form button").locatedBy("//button[.='Log in']");
    public static Target SIGN_UP_NAME_INPUT = Target.the("Sign up name input").locatedBy("//input[@id='sign-username']");
    public static Target SIGN_UP_PASSWORD_INPUT = Target.the("Sing up password input").locatedBy("//input[@id='sign-password']");
    public static Target SIGN_UP_FROM_BUTTON = Target.the("Sing up form button").locatedBy("//button[.='Sign up']");
    public static Target USER_NAME_LABEL = Target.the("User name label").locatedBy("//a[contains(text(),'Welcome ')]");
    public static Target CATEGORY_BUTTON = Target.the("{0} button").locatedBy("//a[contains(text(),'{0}')]");
    public static Target PRODUCT_ITEM_CARD = Target.the("Product {0} item").locatedBy("//div[@class='card-block']//a[contains(text(),'{0}')]");



}
