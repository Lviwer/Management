package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    private UserServiceImpl instance = null;

    public UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
    private UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);

    }

    public void removeUserById(Long userId) {
        for (int i = 0; i < users.size(); i++) {
            User userFromList = users.get(i);
            if (userFromList.getId() == userId) {
                users.remove(i);
                break;
            }
        }
    }
}
