package controller.users;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF.PMF;
import model.entity.*;
import javax.jdo.PersistenceManager;

public class UsersControllerIndex extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// accediendo al usuario
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String query = "select from " + Usuario.class.getName();
		List<Usuario> users = (List<Usuario>) pm.newQuery(query).execute();
		
		if (uGoogle == null) {
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Registro/created.jsp");
			dp.forward(req, res);
		} else if (uGoogle != null) {
			req.setAttribute("users", users);
			// forward the request to the jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Users/index.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
