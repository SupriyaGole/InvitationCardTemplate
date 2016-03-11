package io;

import java.io.File;
import java.io.FileReader;

public class ReadFile {
    private String fileName;

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    public String read() throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new Exception("File not Found");
        }
        int length = (int) file.length();
        FileReader fileReader = new FileReader(file);
        char[] data = new char[length];
        fileReader.read(data);
        return new String(data);
    }
}
