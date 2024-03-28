package za.ac.cput.repository;

/* LocationRepository.java
   LocationRepository class
   Author: Uzzaih Phumelela Ngogela 222135654
   Date: 26 March 2024
*/

import za.ac.cput.domain.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationRepository implements ILocationRepository {

    private static LocationRepository repository = null;
    private final List<Location> locationList;

    private LocationRepository() {
        locationList = new ArrayList<>();
    }

    public static LocationRepository getRepository() {
        if (repository == null) {
            repository = new LocationRepository();
        }
        return repository;
    }

    @Override
    public Location create(Location location) {
        if (location != null && isValidLocation(location)) {
            boolean success = locationList.add(location);
            if (success)
                return location;
        }
        return null;
    }

    private boolean isValidLocation(Location location) {

        return false;
    }

    @Override
    public Location read(String city) {
        for (Location location : locationList) {
            if (location.getCity().equals(city)) {
                return location;
            }
        }
        return null;
    }

    @Override
    public Location update(Location location) {
        String city = location.getCity();
        Location existingLocation = read(city);
        if (existingLocation == null)
            return null;
        if (delete(city)) {
            if (locationList.add(location))
                return location;
            else
                return null;
        }
        return null;
    }

    @Override
    public boolean delete(String city) {
        Location deleteLocation = read(city);

        if (deleteLocation == null)
            return false;
        return locationList.remove(deleteLocation);
    }

    @Override
    public List<Location> getAll() {
        return locationList;
    }
    }
