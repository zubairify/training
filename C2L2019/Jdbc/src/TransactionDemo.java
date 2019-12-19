import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	public static void main(String[] args) {
		String sql1 = "insert into product values (321, 'Redmi Note 5', 9000)";
		String sql2 = "update product set price = 49000 where code=123";
		String sql3 = "delete from product where cod=121";
		Connection conn = null;
		
		try {
			conn = JdbcUtility.getConnection();
			Statement stmt = conn.createStatement();
			// Creating batch of SQL queries to execute in one go.
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			conn.setAutoCommit(false);	// setting auto-commit off
			stmt.executeBatch();
			
			// committing changes on successful execution of batch
			conn.commit();	
			System.out.println("Transaction completed");
		} catch (SQLException e) {
			try {
				// On exception, roll-back changes
				conn.rollback();
				System.out.println("Transaction declined");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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





