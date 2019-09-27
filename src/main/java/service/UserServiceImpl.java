package service;

import api.UserDao;
import api.UserService;
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

    public UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public User getUserById(Long userId) throws IOException {
        return null;
    }

    public User getUserByLogin(String login) throws IOException {
        return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        return false;
    }

    public boolean addUser(User user) throws UserShortLengthPasswordException, UserLoginAlreadyExistException,
            UserShortLengthLoginException {
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

}
