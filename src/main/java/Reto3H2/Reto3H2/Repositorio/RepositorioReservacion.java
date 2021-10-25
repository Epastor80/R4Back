
package Reto3H2.Reto3H2.Repositorio;

import Reto3H2.Reto3H2.Interfaces.InterfaceReservacion;
import Reto3H2.Reto3H2.Modelos.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservacion {
 
    @Autowired
    private InterfaceReservacion crud;
    
    public List <Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    public Optional <Reservation> getReservation(int idReservation){
        return crud.findById(idReservation);
    }        
    
    public Reservation save(Reservation reservation){
        return  crud.save(reservation);
    }
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
 }
