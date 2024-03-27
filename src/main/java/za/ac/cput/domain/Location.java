package za.ac.cput.domain;

import java.util.Objects;
//author: Uzziah Phumelela Ngogela
// 222135654

public class Location {
    private String city;
    private String province;
    private String area;


    private Location () {}

    private Location(Builder builder) {
        this.city = builder.city;
        this.province = builder.province;
        this.area = builder.area;
    }


    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getLocationArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(city, location.city) && Objects.equals(province, location.province) && Objects.equals(area, location.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province, area);
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", lastName='" + area + '\'' +
                '}';
    }

    public static class Builder {
        private String city;
        private String province;
        private String area;

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

        public Builder copy(Location e) {
            this.city = e.city;
            this.province = e.province;
            this.area = e.area;
            return this;
        }

        public Location build() { return new Location(this);}
    }
}

