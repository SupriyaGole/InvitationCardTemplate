import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    private String fileName;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    public String read() throws IOException {
        File file = new File(fileName);
        int length = (int) file.length();
        FileReader fileReader = new FileReader(file);
        char[] data = new char[length];
        fileReader.read(data);
        return new String(data);
    }
}
