package learning.rnd.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB2Connector {

	public static void main(String[] args) {
		String jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
//		String jdbcClassName = "com.ibm.as400.access.AS400JDBCDriver";
		String url = "jdbc:db2://10.252.20.16:8471/FUATDTA ";
//		String user = "ETQAPI";
//		String password = "ETQAPI";
		String user = "FUAT88";
		String password = "FUAT88";

		Connection connection = null;
		try {
			// Load class into memory
			Class.forName(jdbcClassName);
			// Establish connection
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				System.out.println("Connected successfully.");
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
