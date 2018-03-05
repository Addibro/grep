import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;

/**
 * Reads the content from a txt file
 */
public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public List<Line> getContentLines() throws IOException {
        List<Line> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int counter = 1;
        String input;
        while ((input = br.readLine()) != null) {
            lines.add(new Line(counter, input));
            counter++;
        }
        br.close();
        return lines;
    }
}
