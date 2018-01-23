package dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import creationEmail.UserBean;

@Stateless
public class UserDao {

	@PersistenceContext(unitName = "persistence-unit-h2")
	private EntityManager em;

	public void registerUser(UserBean user) {
		em.persist(user);
	}

	public List<UserBean> showAllUsers() {
		return em.createQuery("select e from UserBean e").getResultList();
	}

	public void deleteUsers(Long id) {
		UserBean userBeanToDelete = em.find(UserBean.class, id);
		em.remove(userBeanToDelete);
	}

	public UserBean editAccount(Long UserToEditId) {
		return em.find(UserBean.class, UserToEditId);
	}

	public void updateAccount(UserBean user) {
		em.merge(user);
	}
}
