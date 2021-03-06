package facade;

import entity.domain.Category;
import entity.domain.Clinic;
import entity.domain.Hospital;
import entity.domain.HospitalImage;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public Object findFirstImage(Hospital hospital) {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        return getEntityManager()
                .createNamedQuery("HospitalImage.findByHospital")
                .setParameter("hospital", hospital)
                .getResultList().get(0);
    }

    public Object findCatByName(String name) {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        return getEntityManager().createNamedQuery("Category.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Clinic> findClinicByCat(Category cat) {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        return getEntityManager().createNamedQuery("Clinic.findClinicByCat")
                .setParameter("category", cat)
                .getResultList();
    }

    public List<T> findAll() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findAreas() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        return getEntityManager().createNamedQuery("Area.findNameSorted").getResultList();
    }

    public List<T> findArabicAreas() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        return getEntityManager().createNamedQuery("Area.findArabicNameSorted").getResultList();
    }

    public List<T> findCategoriesSorted() {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        return getEntityManager().createNamedQuery("Category.findAllSorted").getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
