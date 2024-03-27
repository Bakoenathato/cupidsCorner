package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;

/*IUserRepository.java
IUserRepository class
Author Mihle Sivuyise Bontsi (222406917)
Date: 21 March 2024
 */
public interface IUserRepository extends IRepository<User,String>{
    List<User>getAll();
}