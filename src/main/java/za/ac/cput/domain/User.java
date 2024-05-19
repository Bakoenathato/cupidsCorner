package za.ac.cput.domain;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Objects;
import java.time.LocalDateTime;

/*User.java
User class
Author Mihle Sivuyise Bontsi (222406917)
Date 17 May 2024+
.
 */
@Entity (name = "User")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String genderId;
    private String displayId;

    @CreatedDate
    private LocalDateTime createdAt;

    protected User(){
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.createdAt = builder.createdAt;
        this.genderId = builder.genderId;
        this.displayId = builder.displayId;

    }

    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public LocalDateTime getCtreatedAt(){
        return createdAt;
    }
    public String getGenderId() {
        return genderId;
    }
    public String getDisplayId(){
        return displayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(genderId, user.genderId) && Objects.equals(displayId, user.displayId) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, email, firstName, lastName, genderId, displayId, createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", genderId='" + genderId + '\'' +
                ", displayId='" + displayId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder {
        private String userId;
        private String userName;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private LocalDateTime createdAt;
        private String genderId;
        private String displayId;



        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;

        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;

        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;

        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;

        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;

        }
        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;

        }
        public Builder setGenderId(String genderId) {
            this.genderId = genderId;
            return this;

        }
        public Builder setDisplayId(String displayId) {
            this.displayId = displayId;
            return this;

        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.userName = user.userName;
            this.password = user.password;
            this.email = user.email;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.createdAt = user.createdAt;
            this.genderId = user.genderId;
            this.displayId = user.displayId;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}






