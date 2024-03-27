package za.ac.cput.repository;
// nasiphi sunduza 222499028
public interface IRepository <T, Id> {
    T create(T t);

    T read(Id id);

    T update(T t);

    boolean delete(Id id);
}
