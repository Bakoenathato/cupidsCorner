package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Notification
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;
    private String content;
    private NotificationType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId")
    @Column(name = "notificationReceiverId")
    private UserProfile userProfile;

    protected Notification(){}

    private Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.content = builder.content;
        this.type = builder.type;
        this.userProfile = builder.userProfile;
    }

    public long getNotificationId() {
        return notificationId;
    }

    public String getContent() {
        return content;
    }

    public NotificationType getType() {
        return type;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification that)) return false;
        return notificationId == that.notificationId && Objects.equals(content, that.content) && type == that.type && Objects.equals(userProfile, that.userProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, content, type, userProfile);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", userProfile=" + userProfile +
                '}';
    }

    public static class Builder{
        private long notificationId;
        private String content;
        private NotificationType type;
        private UserProfile userProfile;

        public Builder setNotificationId(long notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setType(NotificationType type) {
            this.type = type;
            return this;
        }

        public Builder setUserProfile(UserProfile userProfile) {
            this.userProfile = userProfile;
            return this;
        }

        public Builder copy(Notification notification){
            this.notificationId = notification.notificationId;
            this.content = notification.content;
            this.type = notification.type;
            this.userProfile = notification.userProfile;
            return this;
        }

        public Notification build(){
            return new Notification(this);
        }
    }
}
