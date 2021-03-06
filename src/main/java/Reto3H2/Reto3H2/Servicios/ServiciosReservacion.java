
package Reto3H2.Reto3H2.Servicios;

import Reto3H2.Reto3H2.Repositorio.RepositorioReservacion;
import Reto3H2.Reto3H2.Modelos.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservacion {
    
   @Autowired
   private RepositorioReservacion metodosCrud;
   
   public List<Reservation> getAll(){
       return metodosCrud.getAll();
   }
   
   public Optional <Reservation> getReservation(int idReservation){
       return metodosCrud.getReservation(idReservation);
   }
   
   public Reservation save(Reservation reservation){
    if (reservation.getIdReservation()==null){
        return metodosCrud.save(reservation);
    }else{
        Optional<Reservation> evt =metodosCrud.getReservation(reservation.getIdReservation());
        if (evt.isEmpty()){
            return metodosCrud.save(reservation);
        }else {
            return reservation;
        }
    }
  }

    public Reservation update(Reservation reservation) {
       
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int idReservation) {
        
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
