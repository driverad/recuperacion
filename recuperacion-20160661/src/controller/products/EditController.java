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

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF.PMF;
import model.entity.*;
import javax.jdo.PersistenceManager;

public class EditController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = req.getParameter("id");
			String iddd = null;
			Producto elegido = null;
			String id = req.getParameter("id");
			Producto g = pm.getObjectById(Producto.class, Long.parseLong(id));


			String query = "select from " + Producto.class.getName();
			@SuppressWarnings("unchecked")
			List<Producto> products = (List<Producto>) pm.newQuery(query).execute();
			for (int i = 0; i < products.size(); i++) {
				iddd = products.get(i).getId().toString();
				if (iddd.equals(name)) {
					elegido = products.get(i);
					req.setAttribute("products", elegido);
					
				}
				
			}	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Productos/update.jsp");
			dispatcher.forward(req, res);
		}
		
		
			
}