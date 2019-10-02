package entity.parser;

import entity.User;
import entity.enums.ProductSeparators;

public class UserParser {

    public static User stringToUser(String readLine) {
        String [] userInformations = readLine.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long userId = Long.parseLong(userInformations[0]);
        String login = userInformations[1];
        String password = userInformations[2];

        return new User(userId, login, password);
    }
}
