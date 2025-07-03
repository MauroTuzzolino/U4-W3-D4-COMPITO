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
import java.util.List;
import java.util.Set;

public class GestioneEventi {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        EventoDAO eventoDAO = new EventoDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Location location = new Location("Stadio Centrale", "Torino");
        locationDAO.save(location);

        Persona persona = new Persona("Mauro", "Tuzzolino", "mauro.tuzzolino@example.com",
                LocalDate.of(2005, 10, 3), 'M');
        personaDAO.save(persona);

        Concerto concerto = new Concerto("Concerto Rock", LocalDate.of(2025, 8, 20),
                "Evento musicale", TipoEvento.PUBBLICO, 1000, location,
                GenereConcerto.ROCK, true);
        eventoDAO.save(concerto);

        Partecipazione p1 = new Partecipazione(persona, concerto, StatoPartecipazione.CONFERMATA);
        partecipazioneDAO.save(p1);

        PartitaDiCalcio partita = new PartitaDiCalcio("Derby Milan-Inter", LocalDate.of(2025, 9, 12),
                "Partita di campionato", TipoEvento.PRIVATO, 50000, location,
                "Milan", "Inter", "Milan", 3, 1);
        eventoDAO.save(partita);

        Partecipazione p2 = new Partecipazione(persona, partita, StatoPartecipazione.CONFERMATA);
        partecipazioneDAO.save(p2);

        GaraDiAtletica gara = new GaraDiAtletica("100m Sprint", LocalDate.of(2025, 9, 15),
                "Finale 100 metri", TipoEvento.PUBBLICO, 10, location,
                Set.of(persona), persona); // Mauro partecipa ed è anche il vincitore
        eventoDAO.save(gara);

        Partecipazione p3 = new Partecipazione(persona, gara, StatoPartecipazione.CONFERMATA);
        partecipazioneDAO.save(p3);

        System.out.println("\nConcerti in streaming:");
        List<Concerto> streamingConcerts = eventoDAO.getConcertiInStreaming(true);
        streamingConcerts.forEach(c -> System.out.println("- " + c.getTitolo()));

        System.out.println("\nConcerti ROCK:");
        List<Concerto> rockConcerts = eventoDAO.getConcertiPerGenere(GenereConcerto.ROCK);
        rockConcerts.forEach(c -> System.out.println("- " + c.getTitolo()));

        System.out.println("\nPartite vinte in casa dal Milan:");
        List<PartitaDiCalcio> vinteCasa = eventoDAO.getPartiteVinteInCasa("Milan");
        vinteCasa.forEach(p -> System.out.println("- " + p.getTitolo()));

        System.out.println("\nPartite vinte in trasferta dall’Inter:");
        List<PartitaDiCalcio> vinteTrasferta = eventoDAO.getPartiteVinteInTrasferta("Inter");
        vinteTrasferta.forEach(p -> System.out.println("- " + p.getTitolo()));

        em.close();
        emf.close();
    }
}
