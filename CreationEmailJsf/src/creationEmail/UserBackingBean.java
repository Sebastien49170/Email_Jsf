package creationEmail;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UserDao;

@ManagedBean
@RequestScoped

public class UserBackingBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserBean user;
	
	@EJB
	private UserDao userDao;

	public UserBackingBean() {
		super();
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

	public void registerUser() {
		System.out.println("register user " + user.getEmail());
		userDao.registerUser(user);
	}

	public String showUserHome() {
		System.out.println("User email: " + user.getEmail() +"\tpassword:" + user.getPassword());
		return "homeUser";
	}
}
