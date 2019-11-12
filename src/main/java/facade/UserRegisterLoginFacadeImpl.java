package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;

import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private static UserRegisterLoginFacadeImpl instance = null;
    private UserService userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl() {

    }

    public static UserRegisterLoginFacadeImpl getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }


    public boolean registerUser(User user) {

        try {
            return userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loginUser(String login, String password) {

        try {
            if (userService.isCorrectLoginAndPassword(login, password)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
