package system.dao;

import org.springframework.stereotype.Repository;
import system.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DaoServiceImpl implements DaoService<User> {
    private static final Map<Integer, User> USERS = new HashMap<>();

    private static final AtomicInteger USERS_ID_GENERATION = new AtomicInteger();

    @Override
    public void save(User user) {
        final int userId = USERS_ID_GENERATION.incrementAndGet();
        user.setId(userId);
        USERS.put(userId, user);
    }

    @Override
    public void saveMultiple(List<User> list) {
        for (User user : list) {
            save(user);
        }
    }

    @Override
    public User selectById(int id) {
        return USERS.get(id);
    }

    @Override
    public List<User> selectAll() {
        return new ArrayList<>(USERS.values());
    }

    @Override
    public boolean update(User user, int id) {
        if (USERS.containsKey(id)){
            user.setId(id);
            USERS.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return USERS.remove(id) !=null;
    }
}
