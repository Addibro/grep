package grep;

import java.io.IOException;
import java.util.List;

/**
 * Utilizing multi threading (2) to try to improve search performance
 */
public class GrepMultiThreaded {
    public static void run(String pattern, String file)  throws IOException, InterruptedException {
        long startTime;
        long endTime;
        // starts
        // count milli secs
        startTime = System.currentTimeMillis();
        Reader reader;
        Grep grep1 = null;
        Grep grep2 = null;
        List<Line> part1, part2, allLines = null;

        // check correct arguments
        if (pattern.equals("") || file.equals("")) {
            System.out.println("Arguments should be: \"regex\" fileName");
            System.exit(1);
        } else {
            reader = new Reader(file);
            allLines = reader.getContentLines();
            part1 = allLines.subList(0, allLines.size() / 2);
            part2 = allLines.subList(allLines.size() / 2, allLines.size());
            grep1 = new Grep(pattern, part1);
            grep2 = new Grep(pattern, part2);
        }

        // results
        Thread thread1 = new Thread(grep1);
        Thread thread2 = new Thread(grep2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println((grep1.getResult() == null ? "" : grep1.getResult())
                         + (grep2.getResult() == null ? "" : grep2.getResult()));

        // program ends
        endTime = System.currentTimeMillis();
        System.out.println("Performed in " + (endTime - startTime) + " milli seconds\n");
    }
}
