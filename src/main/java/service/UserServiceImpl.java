package service;

import api.UserDao;
import api.UserService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {


    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    public boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException,
            UserShortLengthPasswordException {

            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException ();
            }

            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }

        return false;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);

        return user != null;
    }

    public void removeUserById(Long userId) {
        userDao.removeUserById(userId);
    }

    public User getUserById(Long userId){
        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            boolean isFoundUser = user.getId().equals(userId);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }



    public User getUserByLogin(String login) {
        List<User> users = getAllUsers();

            for(User user : users)
            {
                boolean isFoundUser = user.getLogin().equals(login);
                if(isFoundUser) return user;
            }

        return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {

        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }
        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPass = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPass;

    }




}
