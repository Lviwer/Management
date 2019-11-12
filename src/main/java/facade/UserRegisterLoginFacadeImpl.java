package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

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


    public String registerUser(User user) {

        try {
            userService.addUser(user);
            return "Register successfully";
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public boolean loginUser(String login, String password) {

       if (userService.isCorrectLoginAndPassword(login, password)) {
           return true;
       }
        return false;
    }
}
