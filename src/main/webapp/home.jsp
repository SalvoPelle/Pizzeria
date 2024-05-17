<%@page import="dao.PizzaDAO"%>
<%@page import="java.util.List"%>
<%@page import="models.Pizza"%>
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
	<form action="" method="post">
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
	</form>
	

</body>
</html>