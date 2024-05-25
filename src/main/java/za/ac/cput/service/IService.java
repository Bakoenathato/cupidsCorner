package za.ac.cput.service;

import java.util.List;
import java.util.Optional;
public interface IService<T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);


//    T save(T entity);
//    Optional<T> findById(ID id);
//    List<T> findAll();
//    T update(ID id, T entity);
//    void deleteById(ID id);
}

