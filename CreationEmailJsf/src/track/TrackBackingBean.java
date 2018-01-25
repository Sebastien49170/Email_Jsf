package track;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import creationEmail.UserBean;
import dao.TrackDao;
import dao.UserDao;

@ManagedBean
@RequestScoped
public class TrackBackingBean {
	private static final long serialVersionUID = 1L;

	private Track track;

	@EJB
	private TrackDao trackDao;

	public TrackBackingBean() {
		track = new Track();
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public TrackDao getTrackDao() {
		return trackDao;
	}

	public void setTrackDao(TrackDao trackDao) {
		this.trackDao = trackDao;
	}

	//----------------Methods-----------------//

	public void addTrack() {
		trackDao.addTrack(track);
	}

	public List<Track> showAllTrack() {
		return trackDao.showAllTrack();
	}

	public String deleteTrack(Long id) {
		trackDao.deleteTrack(id);
		return "trackManagement";
	}

	public String editTrack(Long trackToEditId) {
		this.track = trackDao.findTrack(trackToEditId);
		return "updatetrack";
	}

	public String updateTrack() {
		trackDao.updateTrack(this.track);
		return "trackManagement";
	}
}
