package com.example.service;

import com.example.entity.CD;
import com.example.entity.DVD;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateful
public class AdminService {

    @PersistenceContext
    private EntityManager em;

    // Méthode pour ajouter un CD
    public void addCD(CD cd) {
        em.persist(cd);
    }

    // Méthode pour ajouter un DVD
    public void addDVD(DVD dvd) {
        em.persist(dvd);
    }

    // Méthode pour supprimer un CD
    public void deleteCD(Long cdId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null) {
            em.remove(cd);
        }
    }

    // Méthode pour supprimer un DVD
    public void deleteDVD(Long dvdId) {
        DVD dvd = em.find(DVD.class, dvdId);
        if (dvd != null) {
            em.remove(dvd);
        }
    }

    // Méthode pour récupérer tous les CDs
    public List<CD> findAllCDs() {
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c", CD.class);
        return query.getResultList();
    }

    // Méthode pour récupérer tous les DVDs
    public List<DVD> findAllDVDs() {
        TypedQuery<DVD> query = em.createQuery("SELECT d FROM DVD d", DVD.class);
        return query.getResultList();
    }
}
