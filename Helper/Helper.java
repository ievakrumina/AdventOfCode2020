package Helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {
    public ArrayList<String> readFile(String filePath) {

        ArrayList<String> result = new ArrayList<String>();
        String line;
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            while ((line = file.readLine()) != null) {
                result.add(line);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return result;
    }
}
