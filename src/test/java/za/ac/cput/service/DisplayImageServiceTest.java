package za.ac.cput.service;
import org.junit.jupiter.api.Test;


import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DisplayImageFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrder;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class DisplayImageServiceTest {

    @Autowired
    private DisplayImageService displayImageService;

    private static  DisplayImage displayImage1;
    private static DisplayImage displayImage2;

    @Test
    void a_setup() {
        displayImage1 = DisplayImageFactory.buildDisplayImage(2, "jpeg");
        assertNotNull(displayImage1);
        System.out.println(displayImage1);
        displayImage2 = DisplayImageFactory.buildDisplayImage(3, "pdf");
        assertNotNull(displayImage2);
        System.out.println(displayImage2);


    }
    @Test
    void b_create() {
        DisplayImage created1 = displayImageService(displaymage1);
        assertNotNull(created1);
        System.out.println(created1);
        DisplayImage created2 = displayImageService(displaymage2);
        assertNotNull(created2);
        System.out.println(created2);

    }

   @Test
    void c_read() {
        DisplayImage read = DisplayImage.read(displayImage2.getDisplayId());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void d_update() {
        DisplayImage newDisplayImage = new DisplayImage.Builder().copy(displayImage).setImage("pdf jpeg");
        DisplayImage updated = displayImageService.update(newDisplayImage);
        assertNotNull(updated);
        System.out.println(updated);


    }
    @Test
    void getAll() {
        System.out.println(displayImageService.getAll());
    }
}