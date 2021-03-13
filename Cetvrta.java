import java.util.*;

public class Cetvrta {
    static final String EMPTY = "";

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String nextLine;
        String[] input = new String[2];

        Cetvrta.Rectangle rect = new Cetvrta.Rectangle();

        while(scanner.hasNextLine()) {
            nextLine = scanner.nextLine();
            if (nextLine.trim().equals(EMPTY)) {
                break;
            }

            input = nextLine.split(" ");

            Cetvrta.Point p = new Cetvrta.Point(Integer.parseInt(input[0]), 
                                    Integer.parseInt(input[1]));
            rect.addEdge(p);
        }  
        System.out.println(rect.getMissingEdge());      
    }

    public static class Rectangle {
        private List<Point> edges;

        Rectangle() {
            edges = new ArrayList<>();
        }

        public void addEdge(Point edge) {
            edges.add(edge);
        }

        public Point getMissingEdge() {
            Point missingEdge = null;
            int x1 = Integer.MIN_VALUE, x2 = Integer.MIN_VALUE, y1 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
            int x1Count = 0, x2Count = 0, y1Count = 0, y2Count = 0;
            if (this.edges.size() == 3) {
                for (Point p : this.edges) {
                    if (x1 == Integer.MIN_VALUE || x1 == p.x) {
                        x1 = p.x;
                        x1Count++;
                    } else {
                        x2 = p.x;
                        x2Count++;
                    }
                    if (y1 == Integer.MIN_VALUE || p.y == y1) {
                        y1 = p.y;
                        y1Count++;
                    } else {
                        y2 = p.y;
                        y2Count++;
                    }
                }
                missingEdge = new Point();
                if (x1Count == 2) {
                    missingEdge.x = x2;
                } else {
                    missingEdge.x = x1;
                }
                if (y1Count == 2) {
                    missingEdge.y = y2;
                } else {
                    missingEdge.y = y1;
                }
            }
            
            return missingEdge; 
        }
    }

    public static class Point {
        int x;
        int y;

        Point() {
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.x).append(" ").append(this.y);
            return builder.toString();
        }
    }
}