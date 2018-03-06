package sg.fuji.lib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sg.fuji.lib.constants.LibraryConstants;

/**
 * @author Divahar Sethuraman 
 * This class gets connection to connect to the database
 *
 */

public class ConnectionFactory {
	String driverClassName = LibraryConstants.DRIVER_CLASS;
	String connectionUrl = LibraryConstants.CONN_URL;
	String dbUser = LibraryConstants.DB_USER;
	String dbPwd = LibraryConstants.DB_PASSWORD;

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
