package creationEmail;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class UserBackingBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserBean user;

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

	public String showUserHome() {
		return "homeUser";
	}
}
