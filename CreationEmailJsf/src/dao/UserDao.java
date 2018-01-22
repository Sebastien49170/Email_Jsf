package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import creationEmail.UserBean;

@Stateless
public class UserDao {
	
	@PersistenceContext(unitName = "persistence-unit-h2")
	private EntityManager em;
	
	public void registerUser(UserBean user) {
		System.out.println("em: " + em);;
		em.persist(user);
	}

}
