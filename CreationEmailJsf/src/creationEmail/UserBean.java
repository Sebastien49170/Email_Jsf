package creationEmail;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String password;
	private String email;
	
	public UserBean(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public UserBean() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
