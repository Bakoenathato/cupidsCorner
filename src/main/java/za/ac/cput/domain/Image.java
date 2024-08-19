package za.ac.cput.domain;
/*
    Image.java
    Image class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.util.Arrays;
import java.util.Objects;

public class Image {

    @Lob
    @Column(length = 100000)
    private byte[] photo;
    private String description;
    private String title;

    private Image(){

    }

    private Image(Builder builder){
        this.photo =  builder.photo;
        this.description = builder.description;
        this.title = builder.title;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image image)) return false;
        return Objects.deepEquals(getPhoto(), image.getPhoto()) && Objects.equals(getDescription(), image.getDescription()) && Objects.equals(getTitle(), image.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(getPhoto()), getDescription(), getTitle());
    }

    @Override
    public String toString() {
        return "Image{" +
                "photo=" + Arrays.toString(photo) +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static class Builder{

        private byte[] photo;
        private String description;
        private String title;

        public Builder setPhoto(byte[] photo) {
            this.photo = photo;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder copy(Image image){
            this.photo = image.photo;
            this.description = image.description;
            this.title = image.title;
            return this;
        }

        public Image build(){
            return new Image(this);
        }
    }
}
