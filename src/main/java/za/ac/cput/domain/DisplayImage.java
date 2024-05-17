package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.util.Objects;


@Entity
public class DisplayImage {

    @Id
    private long displayId;

    private String image;


    protected DisplayImage() {
    }

    private DisplayImage(Builder builder) {
        this.displayId = builder.displayId;
        this.image = builder.image;
    }

    public long getDisplayId() {
        return displayId;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayImage that = (DisplayImage) o;
        return displayId == that.displayId && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayId, image);
    }

    @Override
    public String toString() {
        return "DisplayImage{" +
                "displayId=" + displayId +
                ", image='" + image + '\'' +
                '}';
    }

    public static class Builder {
        private long displayId;
        private String image;


        public Builder setDisplayId(long displayId) {
            this.displayId = displayId;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder copy(DisplayImage displayImage) {
            this.displayId = displayImage.displayId;
            this.image = displayImage.image;
            return this;
        }

        public DisplayImage build() {
            return new DisplayImage(this);
        }
    }
}
