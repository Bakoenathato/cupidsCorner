package za.ac.cput.domain;

import java.util.Objects;

public class Image {

    private String url;
    private String description;
    private String title;

    private Image(){

    }

    private Image(Builder builder){
        this.url =  builder.url;
        this.description = builder.description;
        this.title = builder.title;
    }

    public String getUrl() {
        return url;
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
        return Objects.equals(getUrl(), image.getUrl()) && Objects.equals(getDescription(), image.getDescription()) && Objects.equals(getTitle(), image.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getDescription(), getTitle());
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public class Builder{

        private String url;
        private String description;
        private String title;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Builder copy(Image i){
            this.url = i.url;
            this.description = i.description;
            this.title = i.title;
            return this;
        }

        public Image build(){
            return new Image(this);
        }
    }
}
