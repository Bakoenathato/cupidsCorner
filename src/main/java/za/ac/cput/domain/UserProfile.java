package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

//UserProfile.java
//UserProfile model class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024
@Entity
@DiscriminatorValue("userprofile")
public class UserProfile  {
    @Id
    private String profileID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User userID;
    private String Intrests;
    private boolean profile_visibility;
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    protected Location LocationID;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "preferenceID")
    private Preference preferenceID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "likeID")
    private Like likes;




    public UserProfile() {
    }

    protected UserProfile(Builder builder) {
        this.profileID = builder.profileID;
        this.userID = builder.userID;
        this.Intrests = builder.Intrests;
        this.profile_visibility = builder.profile_visibility;
        this.created_at = builder.created_at;
        this.LocationID=builder.LocationID;
        this.preferenceID= builder.preferenceID;;
        this.likes=builder.likes;


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

    public boolean getProfile_visibility() {
        return profile_visibility;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Location getLocationID() {
        return LocationID;
    }

    public Preference getPrefernceID() {
        return preferenceID;
    }

    public Likes getLikes() {
        return likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return profile_visibility == that.profile_visibility && Objects.equals(profileID, that.profileID) && Objects.equals(userID, that.userID) && Objects.equals(Intrests, that.Intrests) && Objects.equals(created_at, that.created_at) && Objects.equals(LocationID, that.LocationID) && Objects.equals(preferenceID, that.preferenceID) && Objects.equals(likes, that.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileID, userID, Intrests, profile_visibility, created_at, LocationID, preferenceID, likes);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileID='" + profileID + '\'' +
                ", userID=" + userID +
                ", Intrests='" + Intrests + '\'' +
                ", profile_visibility=" + profile_visibility +
                ", created_at=" + created_at +
                ", LocationID=" + LocationID +
                ", preferenceID=" + preferenceID +
                ", likes=" + likes +
                '}';
    }

    public static class Builder {
        private String profileID;
        private User userID;
        private String Intrests;
        private boolean profile_visibility;
        private LocalDateTime created_at;
        private Location LocationID;
        private Preference preferenceID;
        private Like likes;

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

        public Builder setProfile_visibility(boolean profile_visibility) {
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

        public Builder setPrefernceID(Preference preferenceID) {
            this.preferenceID = preferenceID;
            return this;
        }

        public Builder setLikes(Like likes) {
            this.likes = likes;
            return this
        }

        public Builder copy(UserProfile e) {
        this.profileID = e.profileID;
        this.userID = e.userID;
        this.Intrests = e.Intrests;
        this.profile_visibility = e.profile_visibility;
        this.created_at = e.created_at;
        this.LocationID= e.LocationID;
        this.preferenceID=e.preferenceID;
        this.likes=e.likes;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(this);
    }
}
}

