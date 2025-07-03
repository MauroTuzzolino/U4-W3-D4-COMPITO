package maurotuzzolino.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import maurotuzzolino.entities.Evento;

public class EventoDAO {
    private EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();
        System.out.println("Evento salvato: " + evento.getTitolo());
    }

    public Evento getById(long id) {
        return entityManager.find(Evento.class, id);
    }
}
