package algorithms.graph_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    /*
 * Approach:
 * - This is a graph problem where courses represent nodes, and prerequisites 
 *   represent directed edges. The goal is to check if there is a cycle in the 
 *   graph. If a cycle exists, it's impossible to finish all courses.
 * - We can use **Topological Sorting** (Kahn's Algorithm) or **DFS with cycle 
 *   detection**. 
 * */

 /*
 *  Kahn's Algorithm (BFS-based).
 * - Steps:
 *  1. Build a graph (adjacency list) representing course dependencies.
 *  2. Track the in-degrees (number of prerequisites) for each course.
 *  3. Start with courses having zero prerequisites.
 *  4. Process courses with zero in-degree and reduce in-degree of dependent 
 *     courses. If a course reaches zero in-degree, process it next.
 *  5. If all courses are processed, it means there's no cycle.
 *
 * Time Complexity: O(V + E), where V = numCourses and E = prerequisites.length
 * Space Complexity: O(V + E) for graph storage and in-degrees.
     */
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        // Crear el grafo y un array para contar el grado de entrada (in-degree)
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Inicializar el grafo
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Llenar el grafo con los prerrequisitos y calcular el in-degree
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // Cola para el BFS, iniciando con cursos sin prerequisitos (in-degree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Procesar los nodos en orden topológico
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;

            // Reducir el in-degree de los vecinos
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Si hemos procesado todos los cursos, entonces es posible completarlos
        return processedCourses == numCourses;
    }


    /*
 * Approach DFS:
 * - This is a graph problem where we need to check if a cycle exists. 
 * - We'll use DFS to detect cycles in the graph. The idea is to traverse 
 *   each course and mark it as being visited. If we visit the same course 
 *   again during the current DFS, it means there's a cycle.
 * - We'll maintain three states for each course:
 *   1. Unvisited (0)
 *   2. Visiting (-1): Currently in the DFS stack.
 *   3. Visited (1): Already processed, no cycles found from this course.
 * - If a cycle is detected, return false. If no cycle is detected for all courses,
 *   return true.
 *
 * Time Complexity: O(V + E), where V = numCourses and E = prerequisites.length
 * Space Complexity: O(V + E) for graph storage and visited state tracking.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph (adjacency list)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // Step 2: Create an array to track the state of each course
        int[] visited = new int[numCourses];

        // Step 3: Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(i, graph, visited)) {
                    return false;
                }
            }
        }

        return true; // No cycles detected
    }

    // Helper method to check for cycles using DFS
    private boolean hasCycle(int course, List<List<Integer>> graph, int[] visited) {
        if (visited[course] == -1) {
            return true; // Cycle detected
        }
        if (visited[course] == 1) {
            return false; // Already visited and no cycle
        }

        // Mark the course as being visited (currently in the DFS stack)
        visited[course] = -1;

        // Visit all neighbors (prerequisites) of the current course
        for (int neighbor : graph.get(course)) {
            if (hasCycle(neighbor, graph, visited)) {
                return true;
            }
        }

        // Mark the course as fully processed (no cycle from this course)
        visited[course] = 1;

        return false;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule(); // Ejemplo 1

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Case 1: " + Arrays.deepToString(prerequisites1));
        System.out.println(solution.canFinish(numCourses1, prerequisites1));
        System.out.println("Expected: true \n"); // true

        // Ejemplo 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Case 2: " + Arrays.deepToString(prerequisites2));
        System.out.println(solution.canFinish(numCourses2, prerequisites2)); // false
        System.out.println("Expected: false \n"); // true

        // Ejemplo 3
        int numCourses3 = 4;
        int[][] prerequisites3 = {{2, 1}, {1, 0}, {0, 2}};
        System.out.println("Case 3: " + Arrays.deepToString(prerequisites3));
        System.out.println(solution.canFinish(numCourses3, prerequisites3)); // false
        System.out.println("Expected: false \n"); // true
    }

}
