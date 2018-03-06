package sg.fuji.lib.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sg.fuji.lib.dto.BookDTO;
import sg.fuji.lib.service.impl.BookServiceImpl;

/**
 * @author Divahar Sethuraman 
 * Test class to test all the DB operations
 *
 */

public class BookServiceImplTest {

	BookServiceImpl bookServiceImpl = null;

	@Before
	public void initialize() {
		bookServiceImpl = new BookServiceImpl();
	}

	@Test
	public void insert() {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(1001);
		bookDTO.setTitle("JUnit Fundamaentals");
		bookDTO.setCopies(2);

		bookServiceImpl.insert(bookDTO);
	}

	@Test
	public void search() {
		List<BookDTO> booksList = bookServiceImpl.search("JUnit");
		assertNotEquals(0, booksList.size());
		assertEquals("JUnit Fundamaentals", booksList.get(0).getTitle());
		assertEquals(1001, booksList.get(0).getBookId());
		assertEquals(2, booksList.get(0).getCopies());
	}

	@Test
	public void borrowBook() {
		boolean isSuccess = bookServiceImpl.update(1001, true);
		assertEquals(true, isSuccess);
	}

	@Test
	public void returnBook() {
		boolean isSuccess = bookServiceImpl.update(1001, false);
		assertEquals(true, isSuccess);
	}

	@Test
	public void deleteBook() {
		boolean isSuccess = bookServiceImpl.delete(1001);
		assertEquals(true, isSuccess);
	}

	@After
	public void tearDown() {
		bookServiceImpl = null;
	}

}
