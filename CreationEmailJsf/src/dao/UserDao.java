package dao;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import creationEmail.UserBean;
import track.Track;

@Stateless
public class UserDao {


	@PersistenceContext(unitName = "persistence-unit-h2")
	private EntityManager em;

	@EJB
	TrackDao trackDao;

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

	public UserBean findUser(Long UserToEditId) {
		return em.find(UserBean.class, UserToEditId);
	}

	public void updateAccount(UserBean user) {
		em.merge(user);
	}

	public void addToUser(Long userId, Long trackId) {
		UserBean userToAddTrack = findUser(userId);
		Track trackToAddUser = trackDao.findTrack(trackId);
		userToAddTrack.getTracks().add(trackToAddUser);
		trackToAddUser.setUser(userToAddTrack);
		em.persist(userToAddTrack);
		for(Track track1 : userToAddTrack.getTracks()) {
			System.out.println(track1 +  userToAddTrack.toString());
		}
	}

	public List<Track>showUserTraks(UserBean userShowTracks){
		return userShowTracks.getTracks();
	}
}
