package za.ac.cput.factory;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;


public class DisplayImageFactory {

    public static DisplayImage createDisplayImage(long displayId, byte[] displayImage, User user) {
        if (Helper.isZeroOrLess(displayId) || displayImage == null || displayImage.length == 0 || user == null) {
            return null;
        }

        return new DisplayImage.Builder()
                .setDisplayId(displayId)
                .setDisplayImage(displayImage)
                .setUser(user)
                .build();
    }

    public static DisplayImage createDisplayImage(byte[] displayImage) {
        if (displayImage == null)
            return null;

        long displayId = Helper.generateLongId();
        return new DisplayImage.Builder().setDisplayId(displayId)
                .setDisplayImage(displayImage)
                .build();
    }

}