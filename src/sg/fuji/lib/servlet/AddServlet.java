package sg.fuji.lib.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.fuji.lib.dto.BookDTO;
import sg.fuji.lib.service.impl.BookServiceImpl;
import sg.fuji.lib.util.XmlToDTOUtil;

/**
 * @author Divahar Sethuraman 
 * Servlet for adding a book
 *
 */

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xml = null;
		try {
			byte[] xmlData = new byte[request.getContentLength()];

			// Start reading XML Request as a Stream of Bytes
			InputStream sis = request.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(sis);

			bis.read(xmlData, 0, xmlData.length);

			if (request.getCharacterEncoding() != null) {
				xml = new String(xmlData, request.getCharacterEncoding());
			} else {
				xml = new String(xmlData);
			}

			BookDTO bookDTO = XmlToDTOUtil.mapXmlToDto(xml);
			BookServiceImpl impl = new BookServiceImpl();
			impl.insert(bookDTO);

		} catch (IOException ioe) {

		}

	}
}
