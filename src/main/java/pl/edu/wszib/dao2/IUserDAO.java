package pl.edu.wszib.dao2;

import pl.edu.wszib.model.User;

import java.util.List;

public interface IUserDAO {
    void saveUser(User user);
    User getUserByLogin(String login);
    List<User> getAllUser();
}
