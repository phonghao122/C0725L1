package ss12.service;

import java.util.List;

public interface IService <T>{
    boolean save(T t);
    boolean update(T t);
    boolean delete(int id);
    T findById(int id);
    List<T> findAll();
    boolean existsId(int id);
    List<T> searchProduct(String search);
}
