/**
 * Represents a line with a corresponding string
 */
public class Line {
    private int number;
    private String line;

    public Line(int number, String line) {
        this.number = number;
        this.line = line;
    }

    public int getNumber() {
        return number;
    }

    public String getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "Line " + number + ": " + line;
    }
}
