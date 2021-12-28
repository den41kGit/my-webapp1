package system.service;

import system.model.User;

import java.util.List;


public interface UserService {

    void save(User user);
    User selectById(int id);
    List<User> selectAll();
    boolean update(User element, int id);
    boolean deleteById(int id);

}
