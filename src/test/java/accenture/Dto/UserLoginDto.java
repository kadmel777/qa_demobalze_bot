package accenture.Dto;

import accenture.helper.DataHandler;

public class UserLoginDto {
    private final String username;
    private final String password;


    public UserLoginDto() {
        this.username = DataHandler.generateRandomString(15).concat(DataHandler.generateRandomNumber(3));
        this.password = DataHandler.generateRandomNumber(8);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
