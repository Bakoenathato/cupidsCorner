package za.ac.cput.repository;
/*UserRepository.java
UserRepository class
Author Mihle Sivuyise Bontsi (222406917)
Date: 22 March 2024
        */

import za.ac.cput.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    private static IUserRepository repository = null;
    private final List<User> userList;

    private UserRepository()
    {
        userList = new ArrayList<>();
    }

    public static IUserRepository getRepository()
    {
        if (repository == null)
        {
            repository = new UserRepository();
        }
        return repository;

    }

    @Override
    public User create(User user)
    {
        boolean success = userList.add(user);
        if (success)
            return user;
        return null;
    }

    @Override
    public User read(String id) {
        for (User user : userList) {
            if (user.getUserId().equals(id)) ;
            return user;
        }

        return null;
    }

    @Override
    public User update(User user) {
        String userId = user.getUserId();
        User userOld = read(userId);
        if (userOld == null)
            return null;
        if (delete(userId)) {
            if (userList.add(user))
                return user;
            else
                return null;
        }
        return null;
    }

    @Override
    public boolean delete(String id){
        User UserToDelete = read(id);
        boolean success = userList.remove(UserToDelete);
        return success;


    }

    @Override
    public List<User> getAll() {
        return userList;
    }

}
