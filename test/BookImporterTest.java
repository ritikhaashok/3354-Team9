import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BookImporterTest {

    //Test 1: PDF import(PASS)
    @Test
    public void testValidPdfImport() throws IOException {
        File tempFile = File.createTempFile("sample", ".pdf");

        BookImporter importer = new BookImporter();

        boolean result = importer.importBook(tempFile.getAbsolutePath());

        assertTrue(result);
        assertEquals(1, importer.getLibrary().size());

        tempFile.delete();
    }

    //Test 2: Invalid file type(PASS)
    @Test
    public void testInvalidFileType() throws IOException {
        File tempFile = File.createTempFile("image", ".jpg");

        BookImporter importer = new BookImporter();

        boolean result = importer.importBook(tempFile.getAbsolutePath());

        assertFalse(result);
        assertEquals(0, importer.getLibrary().size());

        tempFile.delete();
    }

    //Test 3: Non-existing file(PASS)
    @Test
    public void testNonExistingFile() {
        BookImporter importer = new BookImporter();

        boolean result = importer.importBook("C:/fakepath/book.pdf");

        assertFalse(result);
    }

    //Test 4: Intentional error -- expects incorrect value for error message
    @Test
    public void testIncorrectExpectation() throws IOException {
        File tempFile = File.createTempFile("sample", ".pdf");

        BookImporter importer = new BookImporter();
        importer.importBook(tempFile.getAbsolutePath());

        assertEquals(0, importer.getLibrary().size());

        tempFile.delete();
    }
}