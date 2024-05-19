package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Gender;
import za.ac.cput.repository.GenderRepository;

import java.util.List;

@Service
public class GenderService implements IGenderService {

    private final GenderRepository repository;

    @Autowired
    public GenderService(GenderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Gender create(Gender gender) {
        return repository.save(gender);
    }

    @Override
    public Gender read(Long genderId) {
        return repository.findById(genderId).orElse(null);
    }

    @Override
    public Gender update(Gender gender) {
        if (repository.existsById(gender.getGenderId())) {
            return repository.save(gender);
        }
        return null;
    }

    @Override
    public void delete(Long genderId) {
        repository.deleteById(genderId);
    }

    @Override
    public List<Gender> getAll() {
        return repository.findAll();
    }
}