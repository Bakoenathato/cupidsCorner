package za.ac.cput.domain;

import java.util.Objects;

/*User.java
User model class
Author Mihle Sivuyise Bontsi (222406917)
Date 21 March 2024
 */


public class User {
    private String userId;
    private String email;
    private String password;

    private User(){

    }
    private User(Builder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.password = builder.password;

    }

    public String getUserId() {

        return userId;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private String userId;
        private String email;
        private String password;


        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;

        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;

        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;

        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.email = user.email;
            this.password = user.password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}







