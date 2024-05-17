package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnManager;
import models.Ordine;
import models.Pizza;


public class OrdineDAO {
	
	public List<Ordine> getAllOrdine() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ConnManager connManager = new ConnManager();
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        List<Ordine> menu = new ArrayList<>();
        List<Pizza> menuOrdine = new ArrayList<>();
		
        try {
        	
            String query = "SELECT * FROM ordine o"
            		+ "JOIN pizza p"
            		+ "ON o.id = p.id_ordine";
            
            conn = connManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            
            while (rs.next()) {
				Ordine o = new Ordine();
				
				
				
				o.setId(rs.getInt("o.id"));
				o.setIsOpen(rs.getString("o.is_open"));
					Pizza p = new Pizza();
					p.setId(rs.getInt("p.id"));
					p.setName(rs.getString("p.name"));
					p.setIngredient(rs.getString("p.ingredient"));
					p.setPrice(rs.getDouble("p.price"));
					menuOrdine.add(p);
				o.setOrdineTavolo(menuOrdine);
				menu.add(o);
				
			}
        
        } catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
        }finally {
        	connManager.closeConnection(conn);
        }
            
		return menu;
	}
	
	public Ordine getOrdine(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ConnManager connManager = new ConnManager();
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        Ordine ord = new Ordine();
		
        try {

        	String driver = "com.mysql.cj.jdbc.Driver";
        	 
        	Class.forName(driver);
        	
            String query = "SELECT * FROM ordine WHERE id =" + id +";";

            conn = connManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            
            while (rs.next()) {
				
				ord.setId(rs.getInt("id"));
				ord.setIsOpen(rs.getString("is_open"));
				
				
			}
            
        } catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
        	connManager.closeConnection(conn);
        }
        
		return ord;
	}

	public void createOrdine(Ordine o) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// storico ordini con id ordine, n pizze per tipologia + totale. chiuso l'ordine si passa al nuovo
		ConnManager connManager = new ConnManager();
		Connection conn = null;
        Statement stmt = null;

        try {

        	String query ="INSERT INTO ordine " +
                    "(id, is_open)" +
                    "VALUES(?, ?, ?, ?);";

            
            conn = connManager.getConnection();
        	stmt = conn.createStatement();
        
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setInt(1, o.getId());
            preparedStatement.setString(2, o.getIsOpen());
            
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
        }finally {
        	connManager.closeConnection(conn);
        }
        
	}
	
//			String queryPizze = "SELECT * FROM pizze WHERE id_ordine = ?";
//			List<Ordine> ordini = popolata dal metodo getAllOrdini;
//			try (PreparedStatement pstmtPizze = conn.prepareStatement(queryPizze)) {
//			for (Ordine ordine : ordini) {
//          	pstmtPizze.setInt(1, ordine.getIdOrdine());
//            	try (ResultSet rsPizze = pstmtPizze.executeQuery()) {
//              	while (rsPizze.next()) {
//                  	int idPizza = rsPizze.getInt("id_pizza");
//                  	String nome = rsPizze.getString("nome");
//                    	String ingredienti = rsPizze.getString("ingredienti");
//                    	BigDecimal prezzo = rsPizze.getBigDecimal("prezzo");
//                    	int idOrdine = rsPizze.getInt("id_ordine");
//
//                    	Pizza pizza = new Pizza(idPizza, nome, ingredienti, prezzo, idOrdine);
//                    	ordine.addPizza(pizza);
//                	}
//				}
//			}
	
	

}
