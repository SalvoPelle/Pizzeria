<%@page import="dao.PizzaDAO"%>
<%@page import="dao.OrdineDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Pizza"%>
<%@page import="models.Ordine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizzeri Home</title>
</head>
<body>

	<h1>Benvenuto in Pizzeria</h1>
	<br>
	<form action="OrdineServ" method="post">
		<h4>Ciao, scegli la tua pizza:</h4>
		<br>
		<label for="menu">Menù: </label>
			<select name="menu" id="menu">
				<%
					PizzaDAO pDao = new PizzaDAO();
				
					List<Pizza> menu = pDao.getAllPizze();
				
					for(Pizza p : menu){
				
				%>
			
				<option value="<%=p.getId()%>">
					<%=p.getName() + " " + p.getPrice()%>
				</option>
				<%
					}
				%>
			</select>
			<br>
			<br>
			<input type="submit" value="Ordina" name="ordinaPizza">
			<input type="submit" value="Scontrino" name="ordinaPizza">
			<select name="ordiniAperti" id="ordiniAperti">
			<%
			Integer idOrdine = (Integer)request.getAttribute("idOrdine");
			
			OrdineDAO ordDAO= new OrdineDAO();
			Ordine ordine = new Ordine();
			
			ordine.setId(idOrdine);
			List<Pizza> ordineEffettuato = ordine.getOrdineTavolo();
			
			if (ordineEffettuato == null) {
		        	ordineEffettuato = new ArrayList<>();
		    	}
			
			for (Pizza p : ordineEffettuato){
			%>
			
				<option value="<%=ordine.getId()%>">
					Ordine:  <%=ordine.getId()+" "+ordine.getOrdineTavolo()%>
				</option>
				<%}%>
			</select>
	</form>

</body>
</html>