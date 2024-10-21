
import java.util.*;

/*
    Merge K Log Files
    You are given k log files where each log file contains timestamps of certain events sorted in ascending order. 
    Each log file is represented as a linked list, with each node representing a timestamp. Your task is to merge 
    all k log files into one sorted log list by timestamp and return the merged list.

    Example 1:

        Input: logs = [ [2023-01-01T08:00:00, 2023-01-01T09:00:00], 
                        [2023-01-01T07:45:00, 2023-01-01T08:30:00], 
                        [2023-01-01T08:15:00], ]
        
        Output: [2023-01-01T07:45:00, 2023-01-01T08:00:00, 2023-01-01T08:15:00, 
                2023-01-01T08:30:00, 2023-01-01T09:00:00]          
    
    Explanation:

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
public class MergeKLogFiles {
    // Approach:
    // 1. Create a priority queue (min-heap) to store timestamps.
    // 2. Add all timestamps from each log file into the priority queue.
    // 3. Poll elements from the priority queue (which gives the smallest timestamp).
    // 4. Store the result in a list and return it at the end.
    // 5. The time complexity is O(N log K), where N is the total number of timestamps
    //    and K is the number of log files.

    public static List<String> mergeKLogFiles(List<List<String>> logs) {
        PriorityQueue<String> minHeap = new PriorityQueue<>();

        // Add all timestamps to the min-heap
        for (List<String> log : logs) {
            minHeap.addAll(log);
        }

        // List to store merged timestamps
        List<String> mergedLogs = new ArrayList<>();

        // Poll timestamps from the min-heap
        while (!minHeap.isEmpty()) {
            mergedLogs.add(minHeap.poll());
        }

        return mergedLogs;
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
