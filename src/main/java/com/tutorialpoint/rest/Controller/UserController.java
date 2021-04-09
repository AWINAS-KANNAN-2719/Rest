package com.tutorialpoint.rest.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.tutorialpoint.rest.Bean.User;
import com.tutorialpoint.rest.Dao.UserDao;

@Path("/user")
public class UserController {

	/*
	 * https://www.java4s.com/web-services/exception-handling-in-restful-web-
	 * services-jax-rs-with-jersey/
	 */
	static UserDao userDao = new UserDao();
	static List<User> userList = new ArrayList<>();

	static {
		userList = userDao.getAllUsers();
	}

	@GET
	@Path("/getAllUsers")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
		System.out.println("insidee");
		return userList;
	}

	/*
	 * PathParam http://localhost:8080/Rest/rest/user/Awinas
	 */

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserUsingPathParam(@PathParam("name") String name) {
		return userList.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(new User());

	}

	/*
	 * Query param http://localhost:8080/Rest/rest/user?name=Karthi
	 */

	@GET
	@Path("qp")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserUsingQueryParam(@QueryParam("name") String name) {
		return userList.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(new User());

	}

	/*
	 * Matrix param http:// localhost:8080/Rest/rest/user/matrix;name=Awinas
	 */

	@GET
	@Path("matrix")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserUsingMatrixParam(@MatrixParam("name") String name) {
		return userList.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(new User());

	}

	/*
	 * http://localhost:8080/Rest/rest/user/getPosAndTeam?pos=Dev&team=Team 1
	 */

	@GET
	@Path("getPosAndTeam")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getPosAndTeam(@QueryParam("pos") String pos, @QueryParam("team") String team) {
		return userList.stream().filter(e -> e.getProfession().equals(pos) && e.getTeam().equals(team))
				.collect(Collectors.toList());

	}

	/* Use Form Param With Post Method */

	@POST
	@Path("getUserById")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserById(@FormParam("txtbxName") int id) {
		return userList.stream().filter(e -> e.getId() == id).findFirst().orElse(new User());

	}

}
