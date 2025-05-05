/**
 * Represents a directed graph using an adjacency matrix structure.
 * Tracks visited nodes to detect potential traps.
 */

import java.util.ArrayList;
public class Graph {
    ArrayList<Node> nodes;         // Collection of graph vertices
    int[][] matrix;                // Adjacency matrix representation
    
    /**
     * Initializes graph with specified dimensions.
     * @param chamber Number of chambers/nodes
     * @param tunnels Number of tunnels/edges
     */
    Graph(int chamber, int tunnels) {
        nodes = new ArrayList<>();
        matrix = new int[chamber][chamber];
    }
    
    /**
     * Adds a new node to the graph structure.
     * @param node Node to be added
     */
    public void addNode(Node node) {
        nodes.add(node);
    }
    
    /**
     * Creates a directed edge between source and destination nodes.
     * Updates visit counts for path tracking.
     * @param src Source node character
     * @param dst Destination node character
     */
    public void addEdge(char src, char dst) {
        int srcNo = 0;
        int dstNo = 0;
        // if src is != to the previous edge
        // Find source node position
        for(int i = 0; i < nodes.size(); i++) {
            boolean highDegreeNode = false;
            if(src == nodes.get(i).data) {
                srcNo = nodes.get(i).chamberNo;

                for(int y = 0; y < matrix.length; y++) // ta
                {
                    if(matrix[srcNo][y] == 1)
                    {
                        
                        highDegreeNode = true;
                    }
                }


                if(highDegreeNode == false && (i == 0 || nodes.get(i).isDisconnected == true)) {
                    nodes.get(i).ifVisited += 1;
                    nodes.get(i).isDisconnected = false;
                }
                

                break;
            }
        }
        
        // Find destination node position
        for(int i = 0; i < nodes.size(); i++) {
            if(dst == nodes.get(i).data) {
                dstNo = nodes.get(i).chamberNo;
                nodes.get(i).ifVisited += 1;
                break;
            }
        }
        
        // Update adjacency matrix
        matrix[srcNo][dstNo] = 1;
    }
    
    /**
     * Determines if any chamber is trapped (visited more than once).
     * @return True if trapped, false otherwise
     */
    public boolean ifTrapped() {
        int checkIndex = 0;
        for(Node i : nodes) {
        
            if (i.ifVisited > 1) {
                return true;
            }
        checkIndex += 1;
        }
        return false;
    }
}


