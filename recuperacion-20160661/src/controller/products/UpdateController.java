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

public class UpdateController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String id = req.getParameter("id2");
		String query = "select from " + Producto.class.getName();
		@SuppressWarnings("unchecked")
		List<Producto> events = (List<Producto>) pm.newQuery(query).execute();
		double precio = Double.parseDouble(req.getParameter("precio"));
		int cantidad = Integer.parseInt(req.getParameter("cantidad"));

		String iddd = null;
		for (int i = 0; i < events.size(); i++) {
			iddd = events.get(i).getId().toString();
			if (iddd.equals(id)) {
				events.get(i).setNombre(req.getParameter("nombre"));
				events.get(i).setPrecio(precio);
				events.get(i).setCantidad(cantidad);
				

			}
			res.sendRedirect("/products");
		}

	}
}
