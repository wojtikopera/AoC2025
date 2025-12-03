import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class Day01_part2 {

    public static int rotate(int current, char direction, int value){
        if(direction == 'R') current = current + value;
        else current = current - value;

        current %= 100;
        if(current < 0)
            current += 100;

        return current;
    }

    public static int countHitsDuringRotation(int current, char direction, int value) {
        int hits = 0;

        for (int i = 0; i < value; i++) {

            if (direction == 'R') {
                current = (current + 1) % 100;
            } else {
                current = (current - 1 + 100) % 100;
            }

            if (current == 0) {
                hits++;
            }
        }

        return hits;
    }


    static void main() throws IOException {

        int current = 50;
        int suma = 0;

        List<String> lines = Files.readAllLines(Path.of("input", "input01.txt"));

        for (String cmd : lines) {

            cmd = cmd.trim();
            if (cmd.isEmpty()) {
                continue;
            }

            char direction = cmd.charAt(0);
            int value = Integer.parseInt(cmd.substring(1));

            suma = suma + countHitsDuringRotation(current,direction,value);

            current = rotate(current,direction,value);


        }
        System.out.println(suma);
    }
}
