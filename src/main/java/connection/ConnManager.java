package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
	private final String URL = "jdbc:mysql://localhost:3306/advancia_pizze";
	private final String USER = "root";
	private final String PASS = "salvopelle88";
	
	public ConnManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
	
	public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
	
}
