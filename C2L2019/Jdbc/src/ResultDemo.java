import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultDemo {
	public static void main(String[] args) {
		String sql = "select * from product";
		Connection conn = null;

		try {
			conn = JdbcUtility.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			
			System.out.println(meta.getColumnName(1) +"\t" + meta.getColumnName(2) + 
						"\t" + meta.getColumnLabel(3));
			
			while (rs.next()) {
				System.out.println(rs.getString("code") + "\t" + rs.getString(2) + "\t" + 
						rs.getString(3));
			}
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


