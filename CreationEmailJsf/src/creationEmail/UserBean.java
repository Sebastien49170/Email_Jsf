package creationEmail;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@RequestScoped
@Entity
@Table
public class UserBean  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	public UserBean(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return ("User:\n" + "email: "+ email + "\tpassword: " + password + "\n");
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
