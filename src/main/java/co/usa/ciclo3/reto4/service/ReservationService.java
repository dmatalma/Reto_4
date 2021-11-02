package co.usa.ciclo3.reto4.service;

import co.usa.ciclo3.reto4.model.Reservation;
import co.usa.ciclo3.reto4.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p) {
        if (p.getIdReservation() == null) {
            p.setStatus("created");
            return reservationRepository.save(p);
        } else {
            Optional<Reservation> paux = reservationRepository.getReservation(p.getIdReservation());
            if (paux.isEmpty()) {
                p.setStatus("created");
                return reservationRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Reservation update(Reservation c) {
        if (c.getIdReservation() != null) {
            Optional<Reservation> g = reservationRepository.getReservation(c.getIdReservation());
            if (!g.isEmpty()) {
                if (c.getStartDate() != null) {
                    g.get().setStartDate(c.getStartDate());
                }
                if (c.getDevolutionDate() != null) {
                    g.get().setDevolutionDate(c.getDevolutionDate());
                }
                if (c.getStatus() != null) {
                    g.get().setStatus(c.getStatus());
                }
                if (c.getClient() != null) {
                    g.get().setClient(c.getClient());
                }
                if (c.getSkate()!= null) {
                    g.get().setSkate(c.getSkate());
                }
                if (c.getScore() != null) {
                    g.get().setScore(c.getScore());
                }
                return reservationRepository.save(g.get());
            }
        }
        return c;
    }

    public boolean deleteReservation(int id) {
        Boolean d = getReservation(id).map(Reservation -> {
            reservationRepository.delete(Reservation);
            return true;
        }).orElse(false);
        return d;
    }

}
