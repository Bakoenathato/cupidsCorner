package za.ac.cput.factory;

import za.ac.cput.domain.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory {

    public static Gender buildGender(String genderId, String description) {
        if (Helper.isNullOrEmpty(genderId) || Helper.isNullOrEmpty(description)) {
            return null;
        }
        return new Gender.Builder()
                .setGenderId(genderId)
                .setDescription(description)
                .build();
    }


}