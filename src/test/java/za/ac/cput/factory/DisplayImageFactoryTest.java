package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.DisplayImage;


class DisplayImageFactoryTest {


    @Test
    void buildUser() {
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage(2, "jpeg");
        assertNotNull(displayImage);
        System.out.println(displayImage);
    }

    @Test
    void testBuildUserWithFail() {
        DisplayImage displayImage = DisplayImageFactory.createDisplayImage("jpeg");
        assertNotNull(displayImage);
        System.out.println(displayImage);
    }
}