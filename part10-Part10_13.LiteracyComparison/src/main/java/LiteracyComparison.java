import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Comparator;

public class LiteracyComparison {

    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .sorted(Comparator.comparing(l -> l[5]))
                    .map(parts -> {
                        String country = parts[3];
                        String year = parts[4];
                        String gender = parts[2].trim().split(" ")[0];
                        String percent = parts[5];

                        return MessageFormat.format("{0} ({1}), {2}, {3}", country, year, gender, percent);
                    })

                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
