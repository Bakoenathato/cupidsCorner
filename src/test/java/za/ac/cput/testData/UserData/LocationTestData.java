package za.ac.cput.testData.UserData;

import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;

public class LocationTestData {

    public static Location getLocationTestData1() {
        return LocationFactory.buildLocationWithoutProfile(1401L
                , "Springs"
                , "GrandBlue"
                , "EastBlue");

    }

    public static Location getLocationTestData2() {
        return LocationFactory.buildLocationWithoutProfile(1402L,
                "Valley",
                "GreenField",
                "WestSide");
    }

    public static Location getLocationTestData3() {
        return LocationFactory.buildLocationWithoutProfile(1403L,
                "Mountain",
                "HighPeak",
                "NorthRange");
    }

    public static Location getLocationTestData4() {
        return LocationFactory.buildLocationWithoutProfile(1404L,
                "Desert",
                "SandDune",
                "SouthArea");
    }

    public static Location getLocationTestData5() {
        return LocationFactory.buildLocationWithoutProfile(1405L,
                "Forest",
                "PineTree",
                "EastWood");
    }

}
