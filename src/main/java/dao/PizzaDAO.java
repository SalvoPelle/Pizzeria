package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnManager;
import models.Pizza;

public class PizzaDAO {
	
	public List<Pizza> getAllPizze() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		ConnManager connManager = new ConnManager();
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        List<Pizza> menu = new ArrayList<>();
		
        try {
        	
            String query = "SELECT * FROM pizze";
            
            conn = connManager.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            
            while (rs.next()) {
				Pizza p = new Pizza();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setIngredient(rs.getString("ingredient"));
				p.setPrice(rs.getDouble("price"));
				menu.add(p);
				
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

}
