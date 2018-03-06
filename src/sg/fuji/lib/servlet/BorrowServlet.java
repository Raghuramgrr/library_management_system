package sg.fuji.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.fuji.lib.dao.BookDAO;
import sg.fuji.lib.dto.BookDTO;
import sg.fuji.lib.service.impl.BookServiceImpl;

/**
 * @author Divahar Sethuraman 
 * Servlet for borrowing a book
 *
 */

@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {

			String value = request.getParameter("values");
			int idBegin = value.indexOf("id=");
			int idEnd = value.indexOf("&");

			int id = Integer.valueOf(value.substring(idBegin + 3, idEnd));

			int titleBegin = value.indexOf("title=");

			String title = value.substring(titleBegin + 6);
			
			BookServiceImpl impl = new BookServiceImpl();
			impl.update(id, true);

			response.setContentType("application/xml");
			PrintWriter out = response.getWriter();
			out.println("<books>");
			BookDAO bookDAO = new BookDAO();
			List<BookDTO> bookList = bookDAO.search(title);

			for (BookDTO bookDTO : bookList) {
				if (null != bookDTO) {
					out.println("<book>");
					out.println("<id>" + bookDTO.getBookId() + "</id>");
					out.println("<title>" + bookDTO.getTitle() + "</title>");
					out.println("<copies>" + bookDTO.getCopies() + "</copies>");
					out.println("<available>" + bookDTO.getAvailable() + "</available>");
					out.println("</book>");
				}
			}

			out.println("</books>");
			out.close();

		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
}
