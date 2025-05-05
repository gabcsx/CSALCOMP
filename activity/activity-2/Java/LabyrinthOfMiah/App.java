import java.util.*;

public class App {
    public static void main(String[] args) {
        try {
            String[] parts;
            int n = 0;
            int m = 0;

            Set<String> nodeCheck = new HashSet<>();
            List<String> edgeCheck = new ArrayList<>();

            parts = getInput();

            if (Integer.parseInt(parts[0]) >= 2 && Integer.parseInt(parts[0]) <= 26) {
                n = Integer.parseInt(parts[0]);
            } else {
                System.exit(1);
            }

            if (Integer.parseInt(parts[1]) >= 0 && Integer.parseInt(parts[1]) <= (n * (n - 1) / 2)) {
                m = Integer.parseInt(parts[1]);
            } else {
                System.exit(1);
            }

            for (int i = 0; i < m; i++) {
                parts = getInput();

                if (parts[0].length() > 1 || parts[1].length() > 1) System.exit(1);
                if (!parts[0].equals(parts[0].toUpperCase()) || !parts[1].equals(parts[1].toUpperCase())) System.exit(1);
                if (parts[0].equals(parts[1])) System.exit(1);

                String edge1 = parts[0];
                String edge2 = parts[1];

                for (int j = 0; j < edgeCheck.size(); j += 2) {
                    String e1 = edgeCheck.get(j);
                    String e2 = edgeCheck.get(j + 1);

                    if ((edge1.equals(e1) && edge2.equals(e2)) || (edge1.equals(e2) && edge2.equals(e1))) {
                        System.exit(1);
                    }
                }

                nodeCheck.add(edge1);
                nodeCheck.add(edge2);
                edgeCheck.add(edge1);
                edgeCheck.add(edge2);
            }

            Graph graph = new Graph(nodeCheck.size(), m);
            Map<Character, Integer> chamberMap = new HashMap<>();
            int chamberNo = 0;
            for (String node : nodeCheck) {
                char ch = node.charAt(0);
                Node newNode = new Node(ch);
                newNode.chamberNo = chamberNo;
                graph.addNode(newNode);
                chamberMap.put(ch, chamberNo);
                chamberNo++;
            }

            for (int i = 0; i < edgeCheck.size(); i += 2) {
                char src = edgeCheck.get(i).charAt(0);
                char dst = edgeCheck.get(i + 1).charAt(0);
                graph.addEdge(src, dst);
            }

            if (graph.ifTrapped()) {
                System.out.println("\nTRAPPED");
            } else {
                System.out.println("\nSAFE");
            }

        } catch (Exception e) {
            System.exit(1);
        }
    }

    public static String[] getInput() {
        Scanner userInput = new Scanner(System.in);
        String stringInput = userInput.nextLine();
        return stringInput.split("\\s+");
    }
}
