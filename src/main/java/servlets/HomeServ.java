package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdineDAO;
import models.Ordine;

@WebServlet("/HomeServ")
public class HomeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	OrdineDAO ordDao = new OrdineDAO();
//    	Ordine ord = new Ordine();
//		
//		
//		
//		int idOrdine = ord.getId();
//		request.setAttribute("idOrdine", idOrdine);
    	request.getRequestDispatcher("home.jsp").forward(request, response);	
    }

}
