package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class Gender {
    @Id
    private Long genderId;
    private String description;




    protected Gender() {}

    private Gender(Builder builder) {
        this.genderId = builder.genderId;
        this.description = builder.description;
    }

    public Long getGenderId() {
        return genderId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return Objects.equals(genderId, gender.genderId) &&
                Objects.equals(description, gender.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId, description);
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private Long genderId;
        private String description;

        public Builder setGenderId(Long genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Gender gender) {
            this.genderId = gender.genderId;
            this.description = gender.description;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}