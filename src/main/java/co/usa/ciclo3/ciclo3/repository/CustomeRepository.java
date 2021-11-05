package co.usa.ciclo3.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import co.usa.ciclo3.ciclo3.model.Custome;
import co.usa.ciclo3.ciclo3.repository.crud.CustomeCrudRepository;

@Repository
        public class CustomeRepository {
    
    @Autowired
    private CustomeCrudRepository customeCrudRepository;

    public List<Custome> getAll(){
        return (List<Custome>) customeCrudRepository.findAll();
    }
    public Optional<Custome> getCustome(int id){
        return customeCrudRepository.findById(id);

    }
    public Custome save(Custome c){
        return customeCrudRepository.save(c);
    }

}
