package accenture.Dto;

import accenture.helper.DataHandler;

public class UserPurchaseDataDto {
    private String name;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;

    public UserPurchaseDataDto(){
        this.name = DataHandler.generateRandomString(6).concat(" ").concat(DataHandler.generateRandomString(6));
        this.city = DataHandler.generateRandomString(8);
        this.country = DataHandler.generateRandomString(8);
        this.creditCard = DataHandler.generateRandomNumber(10);
        this.month = DataHandler.generateRandomMonth();
        this.year = DataHandler.generateRandomYear(1990,2023);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
