package dao;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import creationEmail.UserBean;

@Stateless
public class UserDao {

	@PersistenceContext(unitName = "persistence-unit-h2")
	private EntityManager em;

	public void registerUser(UserBean user) {
		System.out.println("em: " + em);;
		em.persist(user);
	}


	public List<UserBean> showUser() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<UserBean> criteria = criteriaBuilder.createQuery(UserBean.class);

		Root<UserBean> root = criteria.from(UserBean.class);
		criteria.select(root);

		Query<UserBean> query = (Query<UserBean>) em.createQuery(criteria);
		List<UserBean> users = query.getResultList();
//		for(UserBean user: users) {
//			System.out.println(user);
//		}
		return users;
	}
	
	public void deleteUser(UserBean user) {
		em.getTransaction().begin();
		user = em.merge(user);//<-Important
		em.remove(user);
		em.getTransaction().commit();
	}
	

}
