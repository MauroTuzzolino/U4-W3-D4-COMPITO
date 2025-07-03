package maurotuzzolino.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import maurotuzzolino.entities.Partecipazione;

public class PartecipazioneDAO {
    private EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione salvata (evento ID: " +
                partecipazione.getEvento().getId() + ", persona ID: " +
                partecipazione.getPersona().getId() + ")");
    }

    public Partecipazione getById(long id) {
        return entityManager.find(Partecipazione.class, id);
    }
}
