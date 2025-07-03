package maurotuzzolino.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import maurotuzzolino.entities.Location;

public class LocationDAO {
    private EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(location);
        transaction.commit();
        System.out.println("Location salvata: " + location.getNome() + ", " + location.getCitta());
    }

    public Location getById(long id) {
        return entityManager.find(Location.class, id);
    }
}
