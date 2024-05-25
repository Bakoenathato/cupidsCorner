package za.ac.cput.domain;

// author: Uzziah Phumelela Ngogela
// 222135654

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class Location {

    @Id
    private Long postalCode;
    private String city;
    private String province;
    private String area;

    //@OneToOne(cascade = CascadeType.ALL)
    protected Location() {}

    private Location(Builder builder) {
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.province = builder.province;
        this.area = builder.area;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(postalCode, location.postalCode) &&
                Objects.equals(city, location.city) &&
                Objects.equals(province, location.province) &&
                Objects.equals(area, location.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, city, province, area);
    }

    @Override
    public String toString() {
        return "Location{" +
                "postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public static class Builder {
        private Long postalCode;
        private String city;
        private String province;
        private String area;

        public Builder setPostalCode(Long postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setArea(String area) {
            this.area = area;
            return this;
        }

        public Builder copy(Location location) {
            this.postalCode = location.postalCode;
            this.city = location.city;
            this.province = location.province;
            this.area = location.area;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}