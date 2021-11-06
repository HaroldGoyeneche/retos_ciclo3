package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservarion){
        return reservationRepository.getReservation(idReservarion);
    }
    
    public Reservation save(Reservation r){
         if (r.getIdReservation()==null){

         
        return reservationRepository.save(r);
        }else{
            Optional<Reservation> caux=reservationRepository.getReservation(r.getIdReservation());
            if(caux.isEmpty()){
                return reservationRepository.save(r); 
            }else{
                return r;
            }
        }
    }
    
}
