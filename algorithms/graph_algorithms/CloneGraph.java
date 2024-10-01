package algorithms.graph_algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list 
(List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 

Test case format:

For simplicity, each node's value is the same as the node's 
index (1-indexed). For example, the first node with val == 1, 
the second node with val == 2, and so on. The graph is represented 
in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent 
a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must 
return the copy of the given node as a reference to the cloned graph.

Example 1:
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

 */

 /*
  * Approach: DFS
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();

        return cloneNode(node, map);
    }

    public Node cloneNode(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) { // if node is in mem, return the node
            return map.get(node.val);
        }

        Node newNode = new Node(node.val); // create the  copied Node with the same value
        // safe copy in map
        map.put(newNode.val, newNode);

        // clone all neighbors
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneNode(n, map)); // this change also the newclone stored in the map
        }
        return newNode;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating test case adjList = [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedGraph = cloneGraph.cloneGraph(node1);

        System.out.println("Cloned graph created successfully.");

        // Check if the graph is correctly cloned
        if (compareGraphs(node1, clonedGraph)) {
            System.out.println("The graph has been correctly cloned.");
        } else {
            System.out.println("The graph has not been correctly cloned.");
        }
    }

    // Method to compare original and cloned graphs
    public static boolean compareGraphs(Node original, Node clone) {
        if (original == null && clone == null) {
            return true;
        }
        if (original == null || clone == null) {
            return false;
        }

        // Use BFS to compare both graphs
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(original);
        visited.put(original, clone);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node clonedNode = visited.get(current);

            if (current.val != clonedNode.val || current.neighbors.size() != clonedNode.neighbors.size()) {
                return false; // Different values or different number of neighbors
            }

            for (int i = 0; i < current.neighbors.size(); i++) {
                Node neighbor = current.neighbors.get(i);
                Node clonedNeighbor = clonedNode.neighbors.get(i);

                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, clonedNeighbor);
                    queue.add(neighbor);
                } else if (visited.get(neighbor) != clonedNeighbor) {
                    return false; // Neighbors mismatch
                }
            }
        }

        return true; // All nodes and neighbors matched
    }
}

// Definition for a Node.
class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
