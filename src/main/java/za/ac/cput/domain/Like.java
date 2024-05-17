package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Like {
    @Id
    private String likeID;
    private String likerID;
    private String LikedID;
    private LocalDateTime liked_at;

    protected Like(){

    }
    private Like (Builder builder){
        this.likeID=builder.likeID;
        this.likerID=builder.likerID;
        this.LikedID=builder.LikedID;
        this.liked_at=builder.liked_at;

    }

    public String getLikeID() {
        return likeID;
    }

    public String getLikerID() {
        return likerID;
    }

    public String getLikedID() {
        return LikedID;
    }

    public LocalDateTime getLiked_at() {
        return liked_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(likeID, like.likeID) && Objects.equals(likerID, like.likerID) && Objects.equals(LikedID, like.LikedID) && Objects.equals(liked_at, like.liked_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeID, likerID, LikedID, liked_at);
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeID='" + likeID + '\'' +
                ", likerID='" + likerID + '\'' +
                ", LikedID='" + LikedID + '\'' +
                ", liked_at=" + liked_at +
                '}';
    }
    public static class Builder{
        private String likeID;
        private String likerID;
        private String LikedID;
        private LocalDateTime liked_at;

        public Builder setLikeID(String likeID) {
            this.likeID = likeID;
            return this;
        }

        public Builder setLikerID(String likerID) {
            this.likerID = likerID;
            return this;
        }

        public Builder setLikedID(String likedID) {
            LikedID = likedID;
            return this;
        }

        public Builder setLiked_at(LocalDateTime liked_at) {
            this.liked_at = liked_at;
            return this;
        }
        public Builder copy(Like n){
            this.likeID=n.likeID;
            this.likerID=n.likerID;
            this.LikedID=n.LikedID;
            this.liked_at=n.liked_at;
            return this;

        }
        public Like build(){
            return new Like (this);
        }

    }
}
