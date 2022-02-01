package system.dao;

import java.util.List;


public interface DaoService<T> {

    void save(T element);
    void saveMultiple(List<T> list);
    T selectById(int id);
    List<T> selectAll();
    boolean update(T element, int id);
    boolean deleteById(int id);

}
