/*
 * Represents a node in the graph structure.
 * Maintains visit count for trap detection.
 */
public class Node {
    char data;           // Node identifier (character)
    int chamberNo;       // Position in the adjacency matrix
    int ifVisited;      // Visit counter for trap detection
    boolean isDisconnected;

    /**
     * Initializes a new node with given character identifier.
     * @param data Character representing this node
     */
    Node(char data) {
        this.data = data;
        chamberNo = 0;
        ifVisited = 0;
        isDisconnected = false;
    }
}


