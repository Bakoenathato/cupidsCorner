package za.ac.cput.factory;

import za.ac.cput.domain.Image;
import za.ac.cput.util.Helper;

public class ImageFactory {

    public static Image buildImage(byte[] photo, String description, String title){
        if (photo == null || photo.length == 0 || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(title)){
            return null;
        }

        return new Image.Builder()
                .setPhoto(photo)
                .setTitle(title)
                .setDescription(description)
                .build();
    }
}
