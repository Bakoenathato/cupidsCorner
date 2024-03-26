package za.ac.cput.factory;

import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {

    public static Location createLocation(String city, String province, String area) {

        if (Helper.isNullorEmpty(city) || Helper.isNullorEmpty(province)
                || Helper.isNullorEmpty(area))
            return null;
        return new Location.Builder().setCity(city)
                .setProvince(province)
                .setArea(area)
                .build();
    }
}