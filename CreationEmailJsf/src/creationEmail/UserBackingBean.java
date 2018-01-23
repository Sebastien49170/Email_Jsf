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
	
	public List<UserBean> getUserBeans() {
		return userBeanList;
	}

	public void setUserBeans(List<UserBean> userBeans) {
		this.userBeanList = userBeans;
	}

	//----------------Methods-----------------//
	
	public void registerUser() {
		userDao.registerUser(user);
	}
	
	public String deleteUser(Long id) {
		userDao.deleteUsers(id);
		return "usersManagement";
	}
	
	public String showUser(UserBean user){
	return "homeUser";
	}
	
	public String showAllUsers() {
		userBeanList = userDao.showUser();
		return "usersManagement";
	}
	
	public String editAccount(Long UserToEditId) {
		this.user = userDao.editAccount(UserToEditId);
		return "update";
	}
	
	public String updateAccount() {
		userDao.updateAccount(user);
		return "signup";
	}
	
	
}
