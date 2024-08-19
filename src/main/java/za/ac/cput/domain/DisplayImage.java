package za.ac.cput.domain;

import jakarta.persistence.*;


import java.util.Arrays;
import java.util.Objects;


@Entity
public class DisplayImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long displayId;

    @Lob
    @Column(length = 100000)
    private byte[] displayImage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    protected DisplayImage() {
    }

    private DisplayImage(Builder builder) {
        this.displayId = builder.displayId;
        this.displayImage = builder.displayImage;
        this.user = builder.user;
    }

    public long getDisplayId() {
        return displayId;
    }

    public byte[] getDisplayImage() {
        return displayImage;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisplayImage that)) return false;
        return getDisplayId() == that.getDisplayId() && Objects.deepEquals(getDisplayImage(), that.getDisplayImage()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDisplayId(), Arrays.hashCode(getDisplayImage()), getUser());
    }

    @Override
    public String toString() {
        return "DisplayImage{" +
                "displayId=" + displayId +
                ", displayImage=" + Arrays.toString(displayImage) +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private long displayId;
        private byte[] displayImage;
        private User user;

        public Builder setDisplayId(long displayId) {
            this.displayId = displayId;
            return this;
        }

        public Builder setDisplayImage(byte[] displayImage) {
            this.displayImage = displayImage;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(DisplayImage displayImage) {
            this.displayId = displayImage.displayId;
            this.displayImage = displayImage.displayImage;
            this.user = displayImage.user;
            return this;
        }

        public DisplayImage build() {
            return new DisplayImage(this);
        }
    }
}
