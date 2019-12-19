import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class JdbcUtility {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;

		// Registering driver with Driver Manager
		DriverManager.registerDriver(new OracleDriver());
		// Requesting connection from Driver Manager
		conn = DriverManager.getConnection(url, "scott", "tiger");
		
		return conn;
	}
}

