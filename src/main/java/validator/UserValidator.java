package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;

import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;


import java.io.IOException;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;


    private static UserValidator instance = null;
    private UserDao userDao = UserDaoImpl.getInstance(); //DOPISZ METODĘ

    private UserValidator() {

    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException,
            UserShortLengthPasswordException {
        if (isPasswordLengthEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("Password is too short");
        if (isLoginLengthEnough(user.getLogin()))
            throw new UserShortLengthLoginException("Login is too short");
        if (isUserByLoginExist(user.getLogin()))
            throw new UserLoginAlreadyExistException("User with this login already exists");

        return true;
    }

    private boolean isPasswordLengthEnough(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean isLoginLengthEnough(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean isUserByLoginExist(String login) {

        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (user == null) return false;

        return true;

    }


}
