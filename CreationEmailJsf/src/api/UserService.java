package api;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import creationEmail.UserBean;
import dao.UserDao;

@Path("user")
public class UserService {
	@EJB
	UserDao userDao;
	
	@GET
	@Path("/show")
	@Produces("application/json")
	public String show(@QueryParam("id")long id) {
		UserBean user;
		user = userDao.findUser(id);
		return user.getEmail();
	}
	
	@DELETE
	@Path("/delete")
	@Produces("application/json")
	public void delete(@QueryParam("id")long id) {
		userDao.deleteUsers(id);
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public void create(@QueryParam("email") String email, @QueryParam("password") String password ) {
		UserBean user= new UserBean();
		user.setEmail(email);
		user.setPassword(password);
		userDao.registerUser(user);
	}
	
	@POST
	@Path("/update")
	@Produces("application/json")
	public void update(@QueryParam("id")long id, @QueryParam("email") String email, @QueryParam("password") String password ) {
		UserBean user= userDao.findUser(id);
		user.setEmail(email);
		user.setPassword(password);
		userDao.updateAccount(user);
	}
}
