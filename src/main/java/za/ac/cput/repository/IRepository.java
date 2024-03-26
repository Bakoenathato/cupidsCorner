<<<<<<< HEAD
package za.ac.cput.repo;

public interface IRepository<T,ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);

}
=======
package za.ac.cput.repository;

/* IRepository.java
   IRepository interface
   Author: Leonard Gabriel Langa (221069054)
   Date: 25 March 2024
*/

public interface IRepository <T, ID>
{
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);}
>>>>>>> 1c3c743 (IRepository)
