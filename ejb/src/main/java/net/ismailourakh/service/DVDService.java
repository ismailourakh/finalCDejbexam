package net.ismailourakh.ejb;

import net.ismailourakh.entity.DVD;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DVDService {

    @PersistenceContext(unitName = "CDDVDManagementPU")
    private EntityManager entityManager;

    public void save(DVD dvd) {
        entityManager.persist(dvd);
    }

    public void update(DVD dvd) {
        entityManager.merge(dvd);
    }

    public DVD find(int id) {
        return entityManager.find(DVD.class, id);
    }

    public List<DVD> findAll() {
        TypedQuery<DVD> query = entityManager.createQuery("SELECT d FROM DVD d", DVD.class);
        return query.getResultList();
    }

    public void delete(int id) {
        DVD dvd = entityManager.find(DVD.class, id);
        if (dvd != null) {
            entityManager.remove(dvd);
        }
    }
}
