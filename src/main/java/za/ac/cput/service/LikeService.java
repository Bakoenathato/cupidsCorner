package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Like;
import za.ac.cput.repository.LikeRepository;

import java.util.List;

@Service
public class LikeService implements ILikeService {
    public LikeRepository repository;
    @Autowired
    LikeService(LikeRepository repository){
        this.repository=repository;
    }

    @Override
    public Like create(Like like) {
        return repository.save(like);
    }

    @Override
    public Like read(Long likeID) {
        return repository.findById(likeID).orElse(null);
    }

    @Override
    public Like update(Like like) {
        return repository.save(like);
    }

    @Override
    public void delete(Long likeID) {
        repository.deleteById(likeID);
    }


    @Override
    public List<Like> getall() {
        return repository.findAll();
    }

}
