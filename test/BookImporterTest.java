import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookImporterTest {

    @Test
    public void testValidPdfImport() {
        BookImporter importer = new BookImporter();

        boolean result = importer.importBook("C:/Users/ritua/Downloads/EPCS Workshop Summary.pdf");

        assertTrue(result);
        assertEquals(1, importer.getLibrary().size());
    }

    @Test
    public void testInvalidFileType() {
        BookImporter importer = new BookImporter();

        boolean result = importer.importBook("C:/Users/ritua/Downloads/randomPic.jpg");

        assertFalse(result);
        assertEquals(0, importer.getLibrary().size());
    }

    @Test
    public void testNonExistingFile() {
        BookImporter importer = new BookImporter();

        boolean result = importer.importBook("C:/fakepath/book.pdf");

        assertFalse(result);
    }
}