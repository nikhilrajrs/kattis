import java.util.*;
import java.util.stream.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.io.*;

public class PhoneListGenerator {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        Charset charset = Charset.forName("US-ASCII");
        String start = new StringBuilder().append("3").append(System.lineSeparator())
                                .append("3").append(System.lineSeparator())
                                .append("911").append(System.lineSeparator())
                                .append("97625999").append(System.lineSeparator())
                                .append("91125426").append(System.lineSeparator()).toString();
        Path path = Paths.get("phone_list.txt");
        LongStream randomStream = null;
        StringBuilder entries = null;
        
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        

        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            writer.write(start, 0, start.length());

            //Second test case - 1000 in size
            randomStream = new Random().longs(100l, 9999999999l);
            StringBuilder second = new StringBuilder().append("1000").append(System.lineSeparator());
            randomStream.limit(1000)
                        .forEach(t -> second.append(t).append(System.lineSeparator()));
            writer.write(second.toString(), 0, second.length());

            //Third test case - 1000000 in size
            randomStream = new Random().longs(100l, 9999999999l);
            StringBuilder third = new StringBuilder().append("1000000").append(System.lineSeparator());
            randomStream.limit(1000000)
                        .forEach(t -> third.append(t).append(System.lineSeparator()));
            writer.write(third.toString(), 0, third.length());

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}