package maurotuzzolino;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import maurotuzzolino.dao.EventoDAO;
import maurotuzzolino.dao.LocationDAO;
import maurotuzzolino.dao.PartecipazioneDAO;
import maurotuzzolino.dao.PersonaDAO;
import maurotuzzolino.entities.*;

import java.time.LocalDate;

public class GestioneEventi {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        EventoDAO eventoDAO = new EventoDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Location location = new Location("Sala Conferenze", "Milano");
        locationDAO.save(location);

        Persona persona = new Persona("Mauro", "Tuzzolino", "mauro.tuzzolino@example.com",
                LocalDate.of(2005, 10, 3), 'M');
        personaDAO.save(persona);

        Evento evento = new Evento("Java Day", LocalDate.of(2025, 9, 10),
                "Conferenza dedicata a Java", TipoEvento.PUBBLICO, 150, location);
        eventoDAO.save(evento);

        Partecipazione partecipazione = new Partecipazione(persona, evento, StatoPartecipazione.CONFERMATA);
        partecipazioneDAO.save(partecipazione);

        em.close();
        emf.close();
    }
}
