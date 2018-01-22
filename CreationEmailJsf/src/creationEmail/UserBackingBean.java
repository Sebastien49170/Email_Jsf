package creationEmail;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UserDao;

@ManagedBean
@RequestScoped

public class UserBackingBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserBean user;
	private List<UserBean> userBeanList;
	
	@EJB
	private UserDao userDao;
	
	 @PostConstruct
	    public void init() {
		 userBeanList = userDao.showUser();
	    }
	
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
	
	public String deleteUser(UserBean userToDelete) {
		userDao.deleteUser(userToDelete);
		userBeanList = userDao.showUser();
		return "homeUser";
	}

	
	public String showAllUsers() {
		userBeanList = userDao.showUser();
		return "homeUser";
	}

	public List<UserBean> getUserBeans() {
		return userBeanList;
	}

	public void setUserBeans(List<UserBean> userBeans) {
		this.userBeanList = userBeans;
	}

	public String showUserHome() {
		System.out.println("User email: " + user.getEmail() +"\tpassword:" + user.getPassword());
		return "homeUser";
	}
	
	

}
