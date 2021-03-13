import java.util.*;

public class SpeedLimit {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<LogEntry> logBook = new ArrayList<>();
        LogEntry currentEntry = null;

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.contains(" ")) {
                int value = Integer.parseInt(line);
                if (value == -1) {
                    break;
                } else {
                    currentEntry = new LogEntry();
                    logBook.add(currentEntry);
                }
            } else {
                String[] input = line.split(" ");
                SpeedTimePair pair = new SpeedTimePair(Integer.parseInt(input[0]), 
                                            Integer.parseInt(input[1]));
                currentEntry.addSpeedTimePair(pair);
            }
        }

        for (LogEntry entry : logBook) {
            int totalSpeed = 0;
            int previousTime = 0;
            for (SpeedTimePair pair : entry.logEntries) {
                totalSpeed += pair.speed * (pair.time - previousTime);
                previousTime = pair.time;
            }
            System.out.println(totalSpeed + " miles");
        }
    }

    private static class LogEntry {
        List<SpeedTimePair> logEntries;

        public LogEntry() {
            this.logEntries = new ArrayList<>();
        }

        public void addSpeedTimePair(SpeedTimePair pair) {
            this.logEntries.add(pair);
        }
    }

    private static class SpeedTimePair {
        int time;
        int speed;

        public SpeedTimePair(int speed, int time) {
            this.speed = speed;
            this.time = time;
        }
    }
}