package za.ac.cput.repo;
//IRepository.java
//UserProfile Repo class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024

public interface IRepository<T,ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);

}
