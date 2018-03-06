package sg.fuji.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sg.fuji.lib.dto.BookDTO;

/**
 * @author Divahar Sethuraman This class contains all the database logic to
 *         insert, update books
 *
 */

public class BookDAO {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public BookDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public boolean insert(BookDTO bookDTO) {
		boolean isSuccess = true;
		try {
			String queryString = "INSERT INTO lib(id,title,copies,available) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, bookDTO.getBookId());
			ptmt.setString(2, bookDTO.getTitle());
			ptmt.setInt(3, bookDTO.getCopies());
			ptmt.setInt(4, bookDTO.getCopies());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				isSuccess = false;
				e.printStackTrace();
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();
			}

		}

		return isSuccess;

	}

	public boolean update(int id, boolean isBorrow) {
		boolean isSuccess = true;
		try {
			String queryString = "";

			if (isBorrow)
				queryString = "UPDATE lib SET available=available-1 WHERE id=?";
			else
				queryString = "UPDATE lib SET available=available+1 WHERE id=?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				isSuccess = false;
				e.printStackTrace();
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();

			}
		}

		return isSuccess;
	}

	public List<BookDTO> search(String title) {

		List<BookDTO> bookList = new ArrayList<BookDTO>();

		try {

			String queryString = "SELECT * FROM lib WHERE title LIKE ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, "%" + title + "%");
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBookId(resultSet.getInt("id"));
				bookDTO.setTitle(resultSet.getString("title"));
				bookDTO.setCopies(resultSet.getInt("copies"));
				bookDTO.setAvailable(resultSet.getInt("available"));
				bookList.add(bookDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return bookList;
	}

	public boolean delete(int id) {
		boolean isSuccess = true;
		try {
			String queryString = "DELETE from lib WHERE id=?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				isSuccess = false;
				e.printStackTrace();
			} catch (Exception e) {
				isSuccess = false;
				e.printStackTrace();

			}
		}

		return isSuccess;
	}
}
