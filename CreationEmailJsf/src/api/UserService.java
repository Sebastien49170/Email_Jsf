package api;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import creationEmail.UserBean;
import dao.TrackDao;
import dao.UserDao;

@Path("user")
public class UserService {
	@EJB
	UserDao userDao;
	@EJB
	TrackDao trackDao;

	@GET
	@Path("/show/{id}")
	@Produces("application/json")
	public String show(@PathParam("id")long id) {
		UserBean user;
		user = userDao.findUser(id);
		return user.getEmail();
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public void delete(@PathParam("id")long id) {
		userDao.deleteUsers(id);
	}

	@POST
	@Path("/create/{email}/{password}")
	@Produces("application/json")
	public void create(@PathParam("email") String email, @PathParam("password") String password ) {
		UserBean user= new UserBean();
		user.setEmail(email);
		user.setPassword(password);
		userDao.registerUser(user);
	}

	@PUT
	@Path("/update/{id}/{email}/{password}")
	@Produces("application/json")
	public void update(@PathParam("id")long id, @PathParam("email") String email, @PathParam("password") String password ) {
		UserBean user= userDao.findUser(id);
		user.setEmail(email);
		user.setPassword(password);
		userDao.updateAccount(user);
	}

	@GET
	@Path("/tracklist/show/{id}")
	@Produces("application/json")
	public String showtracks(@PathParam("id")long id) {
		UserBean user= userDao.findUser(id);
		return user.getTracks().toString();
	}
	
	@POST
	@Path("/tracklist/add/{userId}/{trackId}")
	@Produces("application/json")
	public void addTrack(@PathParam("userId")long userId,@PathParam("trackId")long trackId) {
		userDao.addToUser(userId, trackId);
	}
	
	@DELETE
	   @Path("/tracklist/delete/{trackId}/{userId}")
	   @Produces("application/json")
	   public void delete(@PathParam("trackId") long trackId, @PathParam("userId") long userId) {
	       UserBean user;
	       user = userDao.findUser(userId);
	       userDao.deleteTrackFromUser(trackId, user);
	   }
}
