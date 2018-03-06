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

/**
 * @author Divahar Sethuraman 
 * Servlet for viewing books
 *
 */

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("application/xml");
			PrintWriter out = response.getWriter();
			out.println("<books>");
			BookDAO bookDAO = new BookDAO();
			List<BookDTO> bookList = bookDAO.search(request.getParameter("title"));

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
