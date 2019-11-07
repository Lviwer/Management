package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void removeUserById(Long userId);
    void removeUserByLogin(String login);

    List<User> getAllUsers();

    void updateUser (User user);

}
