package sg.fuji.lib.dto;

/**
 * @author Divahar Sethuraman 
 * This class contains all the properties of book
 *
 */

public class BookDTO {
	
	private int bookId;
	private String title;
	private int copies;
	private int available;
		
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}	
}
