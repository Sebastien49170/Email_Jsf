package api;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.TrackDao;
import track.Track;

@Path("track")
public class TrackService {

	@EJB
	TrackDao trackDao;
	
	@GET
	@Path("/show")
	@Produces("application/json")
	public String show(@QueryParam("id")long id) {
		Track track;
		track = trackDao.findTrack(id);
		return track.toString();
	}
	
	@DELETE
	@Path("/delete")
	@Produces("application/json")
	public void delete(@QueryParam("id")long id) {
		trackDao.deleteTrack(id);
	}
	
	@POST
	@Path("/add")
	public void add(@QueryParam("title") String title, @QueryParam("artist") String artist) {
		Track track= new Track();
		track.setArtist(artist);
		track.setTitle(title);
		trackDao.addTrack(track);
	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	public void update(@QueryParam("id")long id, @QueryParam("title") String title, @QueryParam("artist") String artist) {
		Track track= trackDao.findTrack(id);
		track.setTitle(title);
		track.setArtist(artist);
		trackDao.updateTrack(track);
	}
}