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

public class UsersControllerAdd extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		
		
		if (req.getParameter("action").equals("userCreate")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Registro/created.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// process the new account creation and send the user to the account
			// display page
		} else if (req.getParameter("action").equals("userCreatedDo")) {
			// create the new account
			
			Usuario g = new Usuario(req.getParameter("email"),  req.getParameter("password"));
			// persist the entity
			try {
				pm.makePersistent(g);
			} finally {
				pm.close();
			}
			res.sendRedirect("/user");

		
			}
			
			
			
			
		}
		
			
}
