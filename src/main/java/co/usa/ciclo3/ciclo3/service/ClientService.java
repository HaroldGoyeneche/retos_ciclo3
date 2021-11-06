package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client c){
         if (c.getIdClient()==null){

         
        return clientRepository.save(c);
        }else{
            Optional<Client> caux=clientRepository.getClient(c.getIdClient());
            if(caux.isEmpty()){
                return clientRepository.save(c); 
            }else{
                return c;
            }
        }
    }
    
}
