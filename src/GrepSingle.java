import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Single threaded class for searching
 */
public class GrepSingle {
    public static void main(String[] args) throws InterruptedException, IOException {

        // count milli secs
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        Reader reader;
        Grep grep1 = null;
        List<Line> allLines = null;

        // check correct arguments
        if (args.length > 3 || args.length < 2) {
            System.out.println("Arguments should be: pattern fileName");
        } else {
            reader = new Reader(args[1]);
            allLines = reader.getContentLines();
            grep1 = new Grep(args[0], allLines);
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

