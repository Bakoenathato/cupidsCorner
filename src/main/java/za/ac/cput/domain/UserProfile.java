package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Objects;

//UserProfile.java
//UserProfile model class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024
@Entity
@DiscriminatorValue("userprofilr")
public class UserProfile  {
    @Id
    private String profileID;

    private User userID;
    private String Intrests;
    private String profile_visibility;
    private LocalDateTime created_at;
    @OneToMany
    protected Location LocationID;
    private Prefernce prefernceID;



    public UserProfile() {
    }

    protected UserProfile(Builder builder) {
        this.profileID = builder.profileID;
        this.userID = builder.userID;
        this.Intrests = builder.Intrests;
        this.profile_visibility = builder.profile_visibility;
        this.created_at = builder.created_at;
        this.LocationID=builder.LocationID;
        this.prefernceID= builder.prefernceID;;


    }

    public String getProfileID() {
        return profileID;
    }

    public User getUserID() {
        return userID;
    }

    public String getIntrests() {
        return Intrests;
    }

    public String getProfile_visibility() {
        return profile_visibility;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Location getLocationID() {
        return LocationID;
    }

    public Prefernce getPrefernceID() {
        return prefernceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(profileID, that.profileID) && Objects.equals(userID, that.userID) && Objects.equals(Intrests, that.Intrests) && Objects.equals(profile_visibility, that.profile_visibility) && Objects.equals(created_at, that.created_at) && Objects.equals(LocationID, that.LocationID) && Objects.equals(prefernceID, that.prefernceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileID, userID, Intrests, profile_visibility, created_at, LocationID, prefernceID);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileID='" + profileID + '\'' +
                ", userID=" + userID +
                ", Intrests='" + Intrests + '\'' +
                ", profile_visibility='" + profile_visibility + '\'' +
                ", created_at=" + created_at +
                ", LocationID=" + LocationID +
                ", prefernceID=" + prefernceID +
                '}';
    }

    public static class Builder {
        private String profileID;
        private User userID;
        private String Intrests;
        private String profile_visibility;
        private LocalDateTime created_at;
        private Location LocationID;
        private Prefernce prefernceID;

        public Builder setProfileID(String profileID) {
            this.profileID = profileID;
            return this;
        }

        public Builder setUserID(User userID) {
            this.userID = userID;
            return this;
        }

        public Builder setIntrests(String intrests) {
            Intrests = intrests;
            return this;
        }

        public Builder setProfile_visibility(String profile_visibility) {
            this.profile_visibility = profile_visibility;
            return this;
        }

        public Builder setCreated_at(LocalDateTime created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder setLocationID(Location locationID) {
            LocationID = locationID;
            return this;
        }

        public Builder setPrefernceID(Prefernce prefernceID) {
            this.prefernceID = prefernceID;
            return this;
        }

        public Builder copy(UserProfile e) {
        this.profileID = e.profileID;
        this.userID = e.userID;
        this.Intrests = e.Intrests;
        this.profile_visibility = e.profile_visibility;
        this.created_at = e.created_at;
        this.LocationID= e.LocationID;
        this.prefernceID=e.prefernceID;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(this);
    }
}
}

