import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CDService {

    @PersistenceContext
    private EntityManager entityManager;

    // Ajouter un CD
    public void addCD(CD cd) {
        entityManager.persist(cd);
    }

    // Mettre à jour un CD
    public void updateCD(CD cd) {
        entityManager.merge(cd);
    }

    // Supprimer un CD
    public void removeCD(Long id) {
        CD cd = entityManager.find(CD.class, id);
        if (cd != null) {
            entityManager.remove(cd);
        }
    }

    // Rechercher un CD par ID
    public CD findCD(Long id) {
        return entityManager.find(CD.class, id);
    }

    // Lister tous les CD
    public List<CD> findAllCDs() {
        return entityManager.createQuery("SELECT c FROM CD c", CD.class).getResultList();
    }
}
