package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Dao {

	private Connection conn;

	public Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost/bi_db", "root", "");
				System.out.println("Conectou");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return conn;
	}
}