package most_watched_series;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    You are given a list of viewing records where each record consists of the following details:
    - userID: The ID of the user who watched a series.
    - titleID: The ID of the series watched.
    - timestamp: The time at which the series was watched.
    You are required to determine the most streamed series in the last x hours. If there are multiple 
    series with the same maximum number of streams, return all of them.

    Example:

    Input: 
        - records = [
            {"userID": 1, "titleID": "A", "timestamp": "2023-01-01T10:00:00"},
            {"userID": 2, "titleID": "B", "timestamp": "2023-01-01T11:00:00"},
            {"userID": 1, "titleID": "A", "timestamp": "2023-01-01T12:00:00"},
            {"userID": 3, "titleID": "B", "timestamp": "2023-01-01T12:30:00"}
            ]
        - x = 2 hours

    Output: ["B"]

    Explanation:
    - Series A has 2 streams, and Series B has 2 streams.
    - Since B was streamed in the last 2 hours more times than A, the result is ["B"].
    Constraints:

    The service returns a list of objects with userID, titleID, and timestamp.
    You need to count the number of streams for each titleID and return the title(s) with the highest count.
 */
public class MostWatchedSeries {

    public static List<String> findMostStreamedInLastXHours(List<HashMap<String, String>> records, int x) {
        List<String> sol = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime timeRange = now.minusHours(x);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        for (HashMap<String, String> record : records) {
            LocalDateTime timeRecord = LocalDateTime.parse(record.get("timestamp"), formatter);

            if (timeRange.isBefore(timeRecord) || timeRange.isEqual(timeRecord)) {
                map.put(record.get("titleID"), map.getOrDefault(record.get("titleID"), 0) + 1);
            }
        }
        int maxStreamed = 0;
        for (int i : map.values()) {
            if (i > maxStreamed) {
                maxStreamed = i;
            }
        }

        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxStreamed) {
                sol.add(entry.getKey());
            }
        }

        return sol;
    }

    // Método principal para probar la solución
    public static void main(String[] args) {
        // Obtenemos el tiempo actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Crear lista de registros de ejemplo basados en el tiempo actual
        List<HashMap<String, String>> records = new ArrayList<>();

        // Crear registros de visualización usando HashMap
        HashMap<String, String> record1 = new HashMap<>();
        record1.put("userID", "1");
        record1.put("titleID", "A");
        record1.put("timestamp", now.minusHours(4).format(formatter));  // Hace 4 horas
        records.add(record1);

        HashMap<String, String> record2 = new HashMap<>();
        record2.put("userID", "2");
        record2.put("titleID", "B");
        record2.put("timestamp", now.minusHours(1).format(formatter));  // Hace 1 hora
        records.add(record2);

        HashMap<String, String> record3 = new HashMap<>();
        record3.put("userID", "1");
        record3.put("titleID", "A");
        record3.put("timestamp", now.minusMinutes(30).format(formatter));  // Hace 30 minutos
        records.add(record3);

        HashMap<String, String> record4 = new HashMap<>();
        record4.put("userID", "3");
        record4.put("titleID", "B");
        record4.put("timestamp", now.minusMinutes(20).format(formatter));  // Hace 20 minutos
        records.add(record4);

        // Número de horas a considerar
        int x = 2;  // últimas 2 horas

        // Ejecutar el método y mostrar el resultado
        List<String> result = findMostStreamedInLastXHours(records, x);
        System.out.println("Serie(s) más vista(s) en las últimas " + x + " horas: " + result); // expected ["B"]
    }
}
