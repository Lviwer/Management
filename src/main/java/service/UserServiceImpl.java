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
        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            boolean isFoundUser = user.getId().equals(userId);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            boolean isFoundUser = user.getLogin().equals(login);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {

        try {
            return (userValidator.isValidateLoginAndPassword(login, password) || isUserByLoginExist(login));

        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addUser(User user) {
        try {
            if (userValidator.isValidate(user) || isUserByLoginExist(user.getLogin())) {
                userDao.saveUser(user);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UserShortLengthLoginException e) {
            e.printStackTrace();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    private boolean isUserByLoginExist(String login) throws UserLoginAlreadyExistException {
        List<User> users = null;
        try {
            users = userDao.getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (User user : users) {
            boolean isUserExist = user.getLogin().equals(login);
            if (isUserExist) return true;
        }
        return false;
    }
}
