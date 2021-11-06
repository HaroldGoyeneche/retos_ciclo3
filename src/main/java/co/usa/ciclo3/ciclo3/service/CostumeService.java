package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Costume;
import co.usa.ciclo3.ciclo3.repository.CostumeRepository;

@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll() {
        return costumeRepository.getAll();
    }

    public Optional<Costume> getCostume(int id) {
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume c) {
        if (c.getId() == null) {

            return costumeRepository.save(c);
        } else {
            Optional<Costume> caux = costumeRepository.getCostume(c.getId());
            if (caux.isEmpty()) {
                return costumeRepository.save(c);
            } else {
                return c;
            }
        }
    }
}
