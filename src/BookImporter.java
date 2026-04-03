import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BookImporter {

    // This simulates the user's bookshelf
    private List<String> library = new ArrayList<>();

    public boolean importBook(String filePath) {

        // 1. Check if filePath is null or empty
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }

        // 2. Create File object
        File file = new File(filePath);

        // 3. Check if file exists and is actually a file
        if (!file.exists() || !file.isFile()) {
            return false;
        }

        // 4. Check file extension
        String fileName = file.getName().toLowerCase();

        if (fileName.endsWith(".pdf") || fileName.endsWith(".txt")) {
            library.add(fileName);  // Simulate adding to system
            return true;
        }

        return false;
    }

    public List<String> getLibrary() {
        return library;
    }
}