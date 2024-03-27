package za.ac.cput.factory;
import za.ac.cput.util.Helper;
import za.ac.cput.domain.User;

/*UserFactory.java
UserFactory class
Author Mihle Sivuyise Bontsi (222406917)
Date: 24 March 2024
 */

public class UserFactory {
    public static User buildUser(String userId, String email, String password){
        if (Helper.isNullorEmpty(userId) || Helper.isNullorEmpty(email) || Helper.isNullorEmpty(password))
            return null;

        return new User.Builder().setUserId(userId).setEmail(email).setPassword(password).build();

    }

    public static User buildUser(String email, String password){
        if (Helper.isNullorEmpty(email) || Helper.isNullorEmpty(password))
            return null;
        String userId = Helper.generateID();
        return new User.Builder().setUserId(userId).setEmail(email).setPassword(password).build();

    }
}
