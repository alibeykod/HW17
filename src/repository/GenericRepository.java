package repository;

import java.math.BigInteger;
import java.util.List;

public interface GenericRepository<T> {
    void save(T entity);

    void update(T e);

    void delete(T e);

    T findById(BigInteger id);

    List<T> findAll();
}
