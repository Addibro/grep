package grep;

import java.io.IOException;
import java.util.List;

/**
 * Single threaded class for searching
 */
public class GrepSingle {
    public static void run(String pattern, String file) throws InterruptedException, IOException {

        // count milli secs
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        Reader reader;
        Grep grep1 = null;
        List<Line> allLines = null;

        // check correct arguments
        if (pattern.equals("") || file.equals("")) {
            System.out.println("Arguments should be: pattern fileName");
        } else {
            reader = new Reader(file);
            allLines = reader.getContentLines();
            grep1 = new Grep(pattern, allLines);
        }

        Thread thread = new Thread(grep1);
        thread.start();
        thread.join();
        if (grep1.getResult() != null) {
            System.out.println(grep1.getResult());
        } else {
            System.out.println("No match...");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Performed in " + (endTime - startTime) + " milli seconds\n");

    }
}

