package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.repository.DisplayImageRepository;
import java.util.List;

@Service
public class DisplayImageService implements IDisplayImageService{
    private DisplayImageRepository repository;

    @Autowired
    DisplayImageService(DisplayImageRepository repository){
        this.repository = repository;
    }

    @Override
    public DisplayImage create(DisplayImage displayImage) {
        return repository.save(displayImage);
    }

    @Override
    public DisplayImage read(Long displayImageId){
        return repository.findById(displayImageId).orElse(null);
    }

    @Override
    public DisplayImage update(DisplayImage displayImage){
        return repository.save(displayImage);
    }

    @Override
    public List<DisplayImage> getAll(){
        return repository.findAll();
    }
}

