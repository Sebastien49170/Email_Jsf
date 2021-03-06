package creationEmail;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UserDao;
import track.Track;

@ManagedBean
@RequestScoped

public class UserBackingBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserBean user;

	@EJB
	private UserDao userDao;

	public UserBackingBean() {
		user = new UserBean();
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public UserBean getUser() {
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//----------------Methods-----------------//

	public void registerUser() {
		userDao.registerUser(user);
	}

	public List<UserBean> showAllUsers() {
		return userDao.showAllUsers();
	}

	public String deleteUser(Long id) {
		userDao.deleteUsers(id);
		return "usersManagement";
	}

	public String editAccount(Long UserToEditId) {
		this.user = userDao.findUser(UserToEditId);
		return "update";
	}

	public String updateAccount() {
		userDao.updateAccount(this.user);
		return "usersManagement";
	}

	public String editAccountTrack(Long UserToEditId) {
		this.user = userDao.findUser(UserToEditId);
		return "userTrackManagement";
	}

	public void addToUser(Long userId, Track track) {
		userDao.addToUser(userId,track.getId());

	}

	public String findUserTraks(Long userId){
		this.user=userDao.findUser(userId);
		return "userTracksView";
	}

	public List<Track> showUserTraks(){
		return userDao.showUserTraks(this.user);
	}
}
