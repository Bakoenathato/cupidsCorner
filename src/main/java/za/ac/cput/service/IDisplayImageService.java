package za.ac.cput.service;

import za.ac.cput.domain.DisplayImage;

import java.util.List;

public interface IDisplayImageService extends IService<DisplayImage, Long>{
    List<DisplayImage> getAll();
}
