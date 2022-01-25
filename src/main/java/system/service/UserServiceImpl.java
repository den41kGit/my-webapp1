package system.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import system.dao.DaoService;
import system.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private DaoService<User> daoService;


    @Override
    public void save(User user) {
        daoService.save(user);
    }

    @Override
    public User selectById(int id) {
        return (User) daoService.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return daoService.selectAll();
    }

    @Override
    public boolean update(User element, int id) {
        return daoService.update(element, id);
    }

    @Override
    public boolean deleteById(int id) {
        return daoService.deleteById(id);
    }
}
