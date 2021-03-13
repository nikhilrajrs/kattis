import java.util.*;
import java.io.*;

public class WheresMyInternet {

    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split(" ");
        int count = Integer.parseInt(input[1]);
        int numberOfHouses = Integer.parseInt(input[0]);

        if (numberOfHouses == 1) {
            System.out.println("Connected");
            return;
        }

        Tree network = new Tree("1");

        for (int i = 2; i <= numberOfHouses; i++) {
            String value = Integer.toString(i);
            
            Node vertex = new Node(value);
            network.vertices.put(value, vertex);
        }

        while (count > 0) {
            count--;

            input = reader.readLine().split(" ");
            Node vertex1 = network.vertices.get(input[0]);
            Node vertex2 = network.vertices.get(input[1]);

            vertex1.edges.add(vertex2);
            vertex2.edges.add(vertex1);
        }

        dfs(network.root);

        // House 1 is already connected
        network.root.visited = true;

        //Set<Integer> unsettled = new TreeSet<>();
        int j = 0;
        int[] houses = new int[numberOfHouses];
        for (Node vertex : network.vertices.values()) {
            if(!vertex.visited) {
                //unsettled.add(Integer.parseInt(vertex.content));
                houses[j] = Integer.parseInt(vertex.content);
                j++;
            }
        }

        /*if (unsettled.size() != 0) {
            Iterator<Integer> iterator = unsettled.iterator();
            while(iterator.hasNext()) {
                writer.write(iterator.next().toString());
                writer.newLine();
            }
        }*/
        if (j > 0) {
            Arrays.sort(houses, 0, j);
            for (int i = 0; i < j; i++) {
                writer.write(Integer.toString(houses[i]));
                writer.newLine();
            }
        }
        else {
            System.out.println("Connected");
        }
        writer.flush();
    }

    private static void dfs(Node node) {
        if (node.visited || node.edges.size() == 0) {
            return;
        } else {
            node.visited = true;
            for (Node child : node.edges) {
                dfs(child);
            }
        }
    }

    private static class Tree {
        Node root;
        Map<String, Node> vertices;

        public Tree(String rootContent) {
            root = new Node(rootContent);
            vertices = new HashMap<>();
            vertices.put(rootContent, this.root);
        }
    }

    private static class Node {
        String content;
        boolean visited;
        List<Node> edges;

        public Node(String content) {
            this.content = content;
            this.visited = false;
            this.edges = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Node))
                return false;
            Node other = (Node)o;
            if (this.content == null || other.content == null) {
                return false;
            } else {
                return this.content.equals(other.content);
            }
        }

        @Override
        public final int hashCode() {
            return content == null ? 17 : 17 * content.hashCode();
        }
    }
}