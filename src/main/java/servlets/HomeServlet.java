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

import dao.PizzaDAO;
import models.Pizza;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    	PizzaDAO pDao = new PizzaDAO();
//		
//		List<Pizza> menu = new ArrayList<Pizza>();
//		try {
//			List<Pizza> cicleMenu = pDao.getAllPizze();
//		
//			for(Pizza p : cicleMenu){
//				menu.add(p);
//			}
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	request.getRequestDispatcher("home.jsp").forward(request, response);	
    }

}
