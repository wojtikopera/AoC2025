import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day02 {

    public static boolean isDoubled(long n) {
        String s = Long.toString(n);

        if (s.length() % 2 != 0) return false;

        int half = s.length() / 2;
        String first = s.substring(0, half);
        String second = s.substring(half);

        return first.equals(second);
    }

    static void main() throws IOException{

        String line = Files.readString(Path.of("input", "input02_example.txt")).trim();

        System.out.println(line);

        String[] ranges = line.split(",");

        for(String r: ranges){
            r = r.trim();
            String[] parts = r.split("-");

            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);

            for(long i = start; i<=end; i++){
            }


            System.out.println("start: " + start + "\nend: " + end + "\n");
        }

    }

}