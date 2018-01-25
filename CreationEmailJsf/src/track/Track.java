package track;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import creationEmail.UserBean;

//@ManagedBean
//@RequestScoped
@Entity
//@Table
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String title;
	
	@Column
	private String artist;

	@ManyToOne(fetch = FetchType.EAGER)
	private UserBean user;

	public Track() {
	
	}
 
	public Track(long id, String title, UserBean user, String artist) {
		this.id = id;
		this.title = title;
		this.user = user;
		this.artist = artist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
		
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return ("TrackId: " + id + ", Title: " + title + ", Artist: " + artist + "\n");
	}
	
	
}
