package sg.fuji.lib.service;

import java.util.List;

import sg.fuji.lib.dto.BookDTO;

/**
 * @author Divahar Sethuraman 
 * Interface for book service
 *
 */

public interface BookService {
	
	 public boolean insert(BookDTO bookDTO);
	 public boolean update(int id, boolean isBorrow);
	 public List<BookDTO> search(String title);
	 public boolean delete(int id);

}
