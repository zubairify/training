import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = JdbcUtility.getConnection();
			CallableStatement stmt = conn.prepareCall("{call getPrice(?,?)}");
		
			stmt.setInt(1, 123);
			stmt.registerOutParameter(2, Types.DOUBLE);
			
			stmt.execute();
			System.out.println("Price: " + stmt.getDouble(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
