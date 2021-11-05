package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Custome;
import co.usa.ciclo3.ciclo3.repository.CustomeRepository;

@Service
public class CustomeService {

    @Autowired
    private CustomeRepository customeRepository;

    public List<Custome> getAll(){
        return customeRepository.getAll();
    }

    public Optional<Custome> getCustome(int id){
        return customeRepository.getCustome(id);
    }
    
    public Custome save(Custome c){
         if (c.getId()==null){

         
        return customeRepository.save(c);
        }else{
            Optional<Custome> caux=customeRepository.getCustome(c.getId());
            if(caux.isEmpty()){
                return customeRepository.save(c); 
            }else{
                return c;
            }
        }
    }
}
