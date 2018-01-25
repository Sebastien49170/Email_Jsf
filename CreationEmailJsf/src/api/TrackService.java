package api;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.TrackDao;
import track.Track;

@Path("track")
public class TrackService {

	@EJB
	TrackDao trackDao;

	@GET
	@Path("/show/{id}")
	@Produces("application/json")
	public String show(@PathParam("id")long id) {
		Track track;
		track = trackDao.findTrack(id);
		return track.toString();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public void delete(@PathParam("id")long id) {
		trackDao.deleteTrack(id);
	}

	@POST
	@Path("/add/{title}/{artist}")
	public void add(@PathParam("title") String title, @PathParam("artist") String artist) {
		Track track= new Track();
		track.setArtist(artist);
		track.setTitle(title);
		trackDao.addTrack(track);
	}

	@POST
	@Path("/update/{id}/{title}/{artist}")
	@Produces("application/json")
	public void update(@PathParam("id")long id, @PathParam("title") String title, @PathParam("artist") String artist) {
		Track track= trackDao.findTrack(id);
		track.setTitle(title);
		track.setArtist(artist);
		trackDao.updateTrack(track);
	}
}