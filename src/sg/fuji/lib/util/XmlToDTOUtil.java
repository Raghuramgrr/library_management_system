package sg.fuji.lib.util;

import sg.fuji.lib.dto.BookDTO;

/**
 * @author Divahar Sethuraman 
 * Util class to convert XML string to BookDTO
 *
 */

public class XmlToDTOUtil {

	public static BookDTO mapXmlToDto(String xml) {
		int idBegin = xml.indexOf("<id>");
		int idEnd = xml.indexOf("</id>");

		int id = Integer.valueOf(xml.substring(idBegin + 4, idEnd));

		int titleBegin = xml.indexOf("<title>");
		int titleEnd = xml.indexOf("</title>");

		String title = xml.substring(titleBegin + 7, titleEnd);

		int copiesBegin = xml.indexOf("<copies>");
		int copiesEnd = xml.indexOf("</copies>");

		int copies = Integer.valueOf(xml.substring(copiesBegin + 8, copiesEnd));

		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(id);
		bookDTO.setTitle(title);
		bookDTO.setCopies(copies);

		return bookDTO;
	}

}
