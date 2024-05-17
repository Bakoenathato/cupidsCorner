package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Block {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String blocker;
    private String blocked;
    private String timestamp;

    protected Block() {
    }

    private Block(Builder builder) {
        this.Id = builder.Id;
        this.blocker = builder.blocker;
        this.blocked = builder.blocked;
        this.timestamp = builder.timestamp;
    }

    public Long getId() {
        return Id;
    }

    public String getBlocker() {
        return blocker;
    }

    public String getBlocked() {
        return blocked;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // Setters are omitted to keep immutability through the builder pattern

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(Id, block.Id) && Objects.equals(blocker, block.blocker) && Objects.equals(blocked, block.blocked) && Objects.equals(timestamp, block.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, blocker, blocked, timestamp);
    }

    @Override
    public String toString() {
        return "Block{" +
                ", Id='" + Id + '\'' +
                ", blocker='" + blocker + '\'' +
                ", blocked='" + blocked + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public static class Builder {
        private Long Id;

        private String blocker;
        private String blocked;
        private String timestamp;

        public Builder setId(Long Id) {
            this.Id = Id;
            return this;
        }


        public Builder setBlocker(String blocker) {
            this.blocker = blocker;
            return this;
        }

        public Builder setBlocked(String blocked) {
            this.blocked = blocked;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder copy(Block block) {
            this.Id = block.Id;
            this.blocker = block.blocker;
            this.blocked = block.blocked;
            this.timestamp = block.timestamp;
            return this;
        }

        public Block build() {
            return new Block(this);
        }
    }
}
