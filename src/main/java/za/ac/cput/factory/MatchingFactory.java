package za.ac.cput.factory;
/*
    MatchingFactory.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 27 March 2024
*/

import za.ac.cput.domain.Image;
import za.ac.cput.domain.Matching;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

import java.util.Arrays;

public class MatchingFactory {

    public static Matching createMatch (String connections, String user1, String user2/*, String images*/){

        if (Helper.isNullOrEmpty(connections) || Helper.isNullOrEmpty((user1)) || Helper.isNullOrEmpty((user2))
                /*|| Helper.isNullOrEmpty((images))*/)
            return null;

        //connections = Helper.generateId();
        return new Matching.Builder().setConnections(connections)
                .setUser1(user1)
                .setUser2(user2)
                //.setImages(images)
                .build();
    }
}
