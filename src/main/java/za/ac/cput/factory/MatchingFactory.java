package za.ac.cput.factory;

import za.ac.cput.domain.Image;
import za.ac.cput.domain.Matching;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

import java.util.Arrays;

public class MatchingFactory {

    public static Matching createMatch (String connections, UserProfile user1, UserProfile user2, Image[] images){

        if (Helper.isNullOrEmpty(connections) || Helper.isNullOrEmpty(String.valueOf(user1)) || Helper.isNullOrEmpty(String.valueOf(user2))
                || Helper.isNullOrEmpty(Arrays.toString(images)))
            return null;

        return new Matching.Builder().setConnections(connections)
                .setUser1(user1)
                .setUser2(user2)
                .setImages(images)
                .build();
    }
}
