package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    Merge K Log Files
    You are given k log files where each log file contains timestamps of certain events sorted in ascending order. 
    Each log file is represented as a linked list, with each node representing a timestamp. Your task is to merge 
    all k log files into one sorted log list by timestamp and return the merged list.

    Example 1:

Example: 
Input:
    n = 4
    gameSize[] = [9, 2, 4, 6] 
    k = 3 
We note that we will need pen drives of the size of at least 9 units, to store the first game. 
This also turns out to be the minimum size of pen drives that should be ordered to give the games 
to these children. We can use the first pen drive to store the game of size 9, the 2nd one to store 
the second and third games, and the 3rd pen drive to store the fourth game. Hence, the minimum capacity 
of pen drives required is 9 units. 

    The log files are:
    Log 1: 2023-01-01T08:00:00 -> 2023-01-01T09:00:00
    Log 2: 2023-01-01T07:45:00 -> 2023-01-01T08:30:00
    Log 3: 2023-01-01T08:15:00

    After merging them into one sorted log:
    2023-01-01T07:45:00 -> 2023-01-01T08:00:00 -> 2023-01-01T08:15:00 -> 2023-01-01T08:30:00 -> 2023-01-01T09:00:00
    
    You can assume that:

    The input is given as an array of k log lists (each list is sorted in ascending order).
    Each log list contains non-negative integers (representing timestamps).
    The task is to return a merged log list, which is sorted by the timestamp.
 */
public class WhiteboardClass {
    // Approach: 
    // 1: Create a priority queue to store timestamps
    // 2: Add all timestamps from each log file into the priority queue
    // 3: Poll elements from the priority queue 

    public static List<String> mergeKLogFiles(List<List<String>> logs) {
        Queue<String> minHeap = new PriorityQueue<>();

        for (List<String> log : logs) {
            minHeap.addAll(log);
        }

        List<String> solution = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            solution.add(minHeap.poll());
        }
        return solution;
    }

    public static void main(String[] args) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(Arrays.asList("2023-01-01T08:00:00", "2023-01-01T09:00:00"));
        logs.add(Arrays.asList("2023-01-01T07:45:00", "2023-01-01T08:30:00"));
        logs.add(Arrays.asList("2023-01-01T08:15:00"));

        List<String> merged = mergeKLogFiles(logs);
        System.out.println("Merged Log: " + merged);
    }
}
