package za.ac.cput.domain;

import java.util.Arrays;
import java.util.Objects;

public class Matching {

    private String connections;
    private UserProfile user1;
    private UserProfile user2;
    private Image[] images;

    private Matching(){

    }

    private Matching(Builder builder){
        this.connections =  builder.connections;
        this.user1 =  builder.user1;
        this.user2 =  builder.user2;
        this.images = builder.images;
    }

    public String getConnections() {
        return connections;
    }

    public UserProfile getUser1() {
        return user1;
    }public UserProfile getUser2() {
        return user2;
    }


    public Image[] getImages() {
        return images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matching matching)) return false;
        return Objects.equals(getConnections(), matching.getConnections()) && Objects.equals(getUser1(), matching.getUser1()) && Objects.equals(getUser2(), matching.getUser2()) && Arrays.equals(getImages(), matching.getImages());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getConnections(), getUser1(), getUser2());
        result = 31 * result + Arrays.hashCode(getImages());
        return result;
    }

    @Override
    public String toString() {
        return "Matching{" +
                "connections='" + connections + '\'' +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", images=" + Arrays.toString(images) +
                '}';
    }

    public static class Builder{

        private String connections;
        private UserProfile user1;
        private UserProfile user2;
        private Image[] images;

        public Builder setConnections(String connections) {
            this.connections = connections;
            return this;
        }

        public Builder setUser1(UserProfile user1) {
            this.user1 = user1;
            return this;
        }

        public Builder setUser2(UserProfile user2) {
            this.user2 = user2;
            return this;
        }

        public Builder setImages(Image[] images) {
            this.images = images;
            return this;
        }

        public Builder copy(Matching m){
            this.connections =  m.connections;
            this.user1 =  m.user1;
            this.user2 =  m.user2;
            this.images = m.images;
            return this;
        }

        public Matching build(){
            return new Matching(this);
        }
    }
}
