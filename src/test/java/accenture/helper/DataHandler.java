package accenture.helper;

import java.security.SecureRandom;

import static org.apache.fontbox.afm.AFMParser.CHARACTERS;

public class DataHandler {
    public static String generateRandomString(int length) {

        SecureRandom random = new SecureRandom();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

    public static String generateRandomNumber(int numberOfDigits) {

        SecureRandom random = new SecureRandom();
        StringBuilder randomNumberBuilder = new StringBuilder(numberOfDigits);

        int firstDigit = random.nextInt(9) + 1;
        randomNumberBuilder.append(firstDigit);

        for (int i = 1; i < numberOfDigits; i++) {
            int randomDigit = random.nextInt(10);
            randomNumberBuilder.append(randomDigit);
        }

        return randomNumberBuilder.toString();
    }

    public static String generateRandomMonth() {
        SecureRandom random = new SecureRandom();
        return String.valueOf(random.nextInt(12) + 1);
    }

    public static String generateRandomYear(int startYear, int endYear) {
        if (startYear >= endYear) {
            throw new IllegalArgumentException("Invalid range: startYear must be less than endYear");
        }

        SecureRandom random = new SecureRandom();
        return String.valueOf( random.nextInt(endYear - startYear + 1) + startYear);
    }

}
