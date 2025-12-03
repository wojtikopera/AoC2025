import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day01_part1 {

    public static int rotate(int current, char direction, int value){
        if(direction == 'R') current = current + value;
        else current = current - value;

        current %= 100;
        if(current < 0)
            current += 100;

        return current;
    }

    static void main() throws IOException {

        int dial = 50;
        int zeros = 0;

        List<String> lines = Files.readAllLines(Path.of("input", "input01.txt"));

        for (String cmd : lines) {

            cmd = cmd.trim();
            if (cmd.isEmpty()) {
                continue;
            }

            char direction = cmd.charAt(0);
            int value = Integer.parseInt(cmd.substring(1));

            //System.out.println("Before: " + dial);
            dial = rotate(dial, direction, value);
            if(dial==0) zeros++;
            //System.out.println("After:  " + dial + " (" + direction + value + ")");
            //System.out.println();

        }
        System.out.println("zeros: " + zeros);
    }
}
