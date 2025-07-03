package maurotuzzolino.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import maurotuzzolino.entities.Persona;

public class PersonaDAO {
    private EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();
        System.out.println("Persona salvata: " + persona.getNome() + " " + persona.getCognome());
    }

    public Persona getById(long id) {
        return entityManager.find(Persona.class, id);
    }
}
