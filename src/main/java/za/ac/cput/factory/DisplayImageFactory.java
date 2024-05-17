package za.ac.cput.factory;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.util.Helper;


public class DisplayImageFactory {
    public static DisplayImage createDisplayImage(int displayId, String image) {
        if (Helper.isZero(displayId) || image == null)
            return null;
        return new DisplayImage.Builder().setDisplayId(displayId)
                .setImage(image)
                .build();
    }

    public static DisplayImage createDisplayImage(String image) {
        if (image == null)
            return null;

        long displayId = Helper.generateLongId();
        return new DisplayImage.Builder().setDisplayId(displayId)
                .setImage(image)
                .build();
    }

}