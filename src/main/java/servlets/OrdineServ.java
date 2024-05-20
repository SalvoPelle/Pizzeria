package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import dao.OrdineDAO;
import dao.PizzaDAO;
import models.Ordine;
import models.Pizza;

/**
 * Servlet implementation class OrdineServ
 */
@WebServlet("/OrdineServ")
public class OrdineServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public OrdineServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ricevutoOrdine = (String)request.getParameter("menu");
		String submit = (String)request.getParameter("ordinaPizza");
		String idOrdine = (String)request.getParameter("idOrdine");
		
		OrdineDAO ordDao = new OrdineDAO();
		PizzaDAO pizzaDAO = new PizzaDAO();
		
		
		try {
//			
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		switch (submit) {
		case "Ordina":
			try {
				
				Long idOrd = ordDao.createOrdine();
				List<Pizza> compareMenu = pizzaDAO.getAllPizze();
				// TODO sostituire la query precedente con una find by idOrdine
				for (Pizza p : compareMenu) {
					if (Integer.valueOf(ricevutoOrdine) == p.getId()) {
						p.setIdOrdine(ord.getId());
						ord.getOrdineTavolo().add(p);
					}
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("idOrdine", ord.getId());
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;

		case "Scontrino":
			
			return;
			
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
		
		
	}

}
