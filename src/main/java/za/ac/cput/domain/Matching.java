package za.ac.cput.domain;
/*
    Matching.java
    Matching class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import java.util.Arrays;
import java.util.Objects;

public class Matching {

    private String connections;
    private String user1;
    private String user2;
    //private String images;

    private Matching(){

    }

    private Matching(Builder builder){
        this.connections =  builder.connections;
        this.user1 =  builder.user1;
        this.user2 =  builder.user2;
        //this.images = builder.images;
    }

    public String getConnections() {
        return connections;
    }

    public String getUser1() {
        return user1;
    }public String getUser2() {
        return user2;
    }

//    public String getImages() {
//        return images;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matching matching)) return false;
        return Objects.equals(getConnections(), matching.getConnections()) && Objects.equals(getUser1(), matching.getUser1()) && Objects.equals(getUser2(), matching.getUser2()) ;/*&& Objects.equals(getImages(), matching.getImages()*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConnections(), getUser1(), getUser2()/*, getImages()*/);
    }

    @Override
    public String toString() {
        return "Matching{" +
                "connections='" + connections + '\'' +
                ", user1=" + user1 +
                ", user2=" + user2 +
//                ", images=" + images +
                '}';
    }

    public static class Builder{

        private String connections;
        private String user1;
        private String user2;
        //private String images;

        public Builder setConnections(String connections) {
            this.connections = connections;
            return this;
        }

        public Builder setUser1(String user1) {
            this.user1 = user1;
            return this;
        }

        public Builder setUser2(String user2) {
            this.user2 = user2;
            return this;
        }

//        public Builder setImages(String images) {
//            this.images = images;
//            return this;
//        }

        public Builder copy(Matching m){
            this.connections =  m.connections;
            this.user1 =  m.user1;
            this.user2 =  m.user2;
            //this.images = m.images;
            return this;
        }

        public Matching build(){
            return new Matching(this);
        }
    }
}
