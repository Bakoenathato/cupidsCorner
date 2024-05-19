package za.ac.cput.domain;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.Objects;

@Entity
@Table(name = "user_preference")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preferenceId;

//    @OneToOne
//    @JoinColumn(name = "profile_id", nullable = false)
//    private UserProfile profile;

    private String ageRange;
    private String distance;
    private String genderPreference;

    protected Preference() {

    }

    public Preference(Builder builder){
        this.preferenceId = builder.preferenceId;
        //this.profile = builder.profile;
        this.ageRange = builder.ageRange;
        this.distance = builder.distance;
        this.genderPreference = builder.genderPreference;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

//    public UserProfile getProfile() {
//        return profile;
//    }

    public String getAgeRange() {
        return ageRange;
    }

    public String getDistance() {
        return distance;
    }

    public String getGenderPreference() {
        return genderPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preference that)) return false;
        return getPreferenceId() == that.getPreferenceId() && /*Objects.equals(getProfile(), that.getProfile()) &&*/ Objects.equals(getAgeRange(), that.getAgeRange()) && Objects.equals(getDistance(), that.getDistance()) && Objects.equals(getGenderPreference(), that.getGenderPreference());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPreferenceId(), /*getProfile(),*/ getAgeRange(), getDistance(), getGenderPreference());
    }

    @Override
    public String toString() {
        return "Preference{" +
                "preferenceId=" + preferenceId +
                /*", profile=" + profile +*/
                ", ageRange='" + ageRange + '\'' +
                ", distance='" + distance + '\'' +
                ", genderPreference='" + genderPreference + '\'' +
                '}';
    }

    public static class Builder {
        private int preferenceId;
        //private UserProfile profile;
        private String ageRange;
        private String distance;
        private String genderPreference;

        public Builder setPreferenceId(int preferenceId) {
            this.preferenceId = preferenceId;
            return this;
        }

//        public Builder setProfile(UserProfile profile) {
//            this.profile = profile;
//            return this;
//        }

        public Builder setAgeRange(String ageRange) {
            this.ageRange = ageRange;
            return this;
        }

        public Builder setDistance(String distance) {
            this.distance = distance;
            return this;
        }

        public Builder setGenderPreference(String genderPreference) {
            this.genderPreference = genderPreference;
            return this;
        }

        public Builder copy(Preference p) {
            this.preferenceId = p.preferenceId;
            //this.profile = p.getProfile();
            this.ageRange = p.getAgeRange();
            this.distance = p.getDistance();
            this.genderPreference = p.getGenderPreference();
            return this;
        }

        public Preference build() {
            return new Preference(this);
        }
    }
}
