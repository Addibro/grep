import java.io.IOException;
import java.util.List;

/**
 * Utilizing multi threading (2) to try to improve search performance
 */
public class GrepMultiThreaded {
    public static void main(String[] args)  {
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
        if (args.length > 3 || args.length < 2) {
            System.out.println("Arguments should be: \"regex\" fileName");
            System.exit(1);
        } else {
            reader = new Reader(args[1]);
            try {
                allLines = reader.getContentLines();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            part1 = allLines.subList(0, allLines.size() / 2);
            part2 = allLines.subList(allLines.size() / 2, allLines.size());
            grep1 = new Grep(args[0], part1);
            grep2 = new Grep(args[0], part2);
        }

        // results
        Thread thread1 = new Thread(grep1);
        Thread thread2 = new Thread(grep2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println((grep1.getResult() == null ? "" : grep1.getResult())
                         + (grep2.getResult() == null ? "" : grep2.getResult()));

        // program ends
        endTime = System.currentTimeMillis();
        System.out.println("Performed in " + (endTime - startTime) + " milli seconds\n");
    }
}
