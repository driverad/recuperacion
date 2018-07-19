package controller.products;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF.PMF;
import model.entity.Producto;

import javax.jdo.PersistenceManager;

public class AddController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		if (req.getParameter("action").equals("productCreate")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Productos/add.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// process the new account creation and send the user to the account
			// display page
		} else if (req.getParameter("action").equals("productCreatedDo")) {
			// create the new account
			int cantidad = Integer.parseInt(req.getParameter("cantidad"));
			double precio = Double.parseDouble(req.getParameter("precio"));
				Producto g = new Producto( req.getParameter("nombre"), precio,cantidad);
				// persist the entity
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/products");

			
			
			
			
		}
		
	}
}
