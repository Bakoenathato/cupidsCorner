package za.ac.cput.factory;

import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {

    public static Location createLocation(String city, String province, String area) {

        if (Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province)
                || Helper.isNullOrEmpty(area))
            return null;
        return new Location.Builder().setCity(city)
                .setProvince(province)
                .setArea(area)
                .build();
    }
}