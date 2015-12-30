package Service;

import models.Company;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Anton Chernov on 12/30/2015.
 */
public class CompanyService {

    public static List<Company> getList() {
        EntityManager em = JPA.em();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
        Root<Company> from = criteriaQuery.from(Company.class);

        CriteriaQuery<Company> select = criteriaQuery.select(from);
        TypedQuery<Company> q = em.createQuery(select);

        return q.getResultList();
    }

}