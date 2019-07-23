package api;

import entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();//wyciąganie wszystkich Userów
    void addUser (User user);
    void removeUserById(Long userId);
}
