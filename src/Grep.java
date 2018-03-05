import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents a runnable task which will parse an input regex over a txt file
 */
public class Grep implements Runnable {

    private Pattern pattern;
    private List<Line> lines;
    private StringBuilder result;

    public Grep(String pattern, List<Line> lines) {
        result = new StringBuilder();
        this.lines = lines;
        this.pattern = Pattern.compile(pattern);
    }

    public String getResult() {
        return result.toString();
    }

    @Override
    public void run() {
        for (Line line : lines) {
            if (pattern.matcher(line.getLine()).find()) {
                result.append(line.toString()).append("\n");
            }
        }
    }
}

