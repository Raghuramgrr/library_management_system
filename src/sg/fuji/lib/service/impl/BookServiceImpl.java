package sg.fuji.lib.service.impl;

import java.util.List;

import sg.fuji.lib.dao.BookDAO;
import sg.fuji.lib.dto.BookDTO;
import sg.fuji.lib.service.BookService;

/**
 * @author Divahar Sethuraman Implementation class for book service
 *
 */

public class BookServiceImpl implements BookService {

	@Override
	public boolean insert(BookDTO bookDTO) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.insert(bookDTO);

	}

	@Override
	public boolean update(int id, boolean isBorrow) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.update(id, isBorrow);
	}

	@Override
	public List<BookDTO> search(String title) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.search(title);
	}

	@Override
	public boolean delete(int id) {
		BookDAO bookDAO = new BookDAO();
		return bookDAO.delete(id);
	}
}
