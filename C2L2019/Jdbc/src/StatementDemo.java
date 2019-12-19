import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {
	public static void main(String[] args) {
		Connection conn = null;
		String sql = "insert into product values (123, 'iPhone X', 55000)";

		try {
			conn = JdbcUtility.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);	//DML
			System.out.println("Record inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}



