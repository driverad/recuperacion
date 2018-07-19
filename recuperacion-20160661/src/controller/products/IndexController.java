package controller.products;

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

public class IndexController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Producto.class.getName();
		List<Producto> products = (List<Producto>) pm.newQuery(query).execute();
		
			req.setAttribute("products", products);
			// forward the request to the jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Productos/index.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
