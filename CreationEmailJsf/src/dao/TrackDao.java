package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import creationEmail.UserBean;
import track.Track;

@Stateless
public class TrackDao{

	@PersistenceContext(unitName = "persistence-unit-h2")
	private EntityManager em;

	public void addTrack(Track track) {
		System.out.println(track.getArtist() + track.getId()+track.getTitle());
		em.persist(track);
	}

	public List<Track> showAllUsers() {
		return em.createQuery("select e from Track e").getResultList();
	}

	public void deleteTrack(Long id) {
		Track trackToDelete = em.find(Track.class, id);
		em.remove(trackToDelete);
	}

	public Track findTrack(Long trackToEditId) {
		return em.find(Track.class, trackToEditId);
	}

	public void updateTrack(Track track) {
		em.merge(track);
	}

	public List<Track> showAllTrack() {
		return em.createQuery("select e from Track e").getResultList();
	}
}


