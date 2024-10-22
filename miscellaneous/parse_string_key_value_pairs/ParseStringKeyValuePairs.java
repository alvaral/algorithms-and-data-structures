package parse_string_key_value_pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s = "foo=bar hello=world" Output: {"foo": "bar", "hello": "world"}
 */
public class ParseStringKeyValuePairs {

    static Map<String, String> parseKeyValuePairs(String s) {
        Map<String, String> sol = new HashMap<>();

        String[] listString = s.split(" ");
        String nameVar;
        String valueVar;
        for (String pair : listString) {
            String[] pairList = pair.split("=");
            if (pairList.length == 2 && !pairList[0].isEmpty()) {
                nameVar = pairList[0];
                valueVar = pairList[1];
                sol.put(nameVar, valueVar);
            }

        }
        return sol;
    }

    static Map<String, Object> parseKeyValuePairsWithTypes(String s, Map<String, Class<?>> types) {
        Map<String, Object> sol = new HashMap<>();

        String[] listString = s.split(" ");
        String nameVar;
        String valueVar;
        for (String pair : listString) {
            String[] pairList = pair.split("=");
            if (pairList.length == 2 && !pairList[0].isEmpty()) {
                nameVar = pairList[0];
                valueVar = pairList[1];
                if (types.containsKey(nameVar)) {
                    Class<?> type = types.get(nameVar);
                    try {
                        if (type == String.class) {
                            sol.put(nameVar, valueVar);
                        } else if (type == Integer.class) {
                            sol.put(nameVar, Integer.parseInt(valueVar));
                        } else if (type == Boolean.class) {
                            sol.put(nameVar, Boolean.parseBoolean(valueVar));
                        } else if (type == Double.class) {
                            sol.put(nameVar, Double.parseDouble(valueVar));
                        }
                    } catch (NumberFormatException e) {
                        // Handle invalid type conversion
                        System.out.println("Invalid value for key: " + nameVar + " with value: " + valueVar);
                    }
                }

            }
        }
        return sol;
    }

    public static void main(String[] args) {
        // Test cases for the first method (no type conversion)
        System.out.println("Testing parseKeyValuePairs:");
        String input1 = "foo=bar hello=world";
        System.out.println(parseKeyValuePairs(input1)); // Expected: {foo=bar, hello=world}

        String input2 = "key1=value1 key2=value2";
        System.out.println(parseKeyValuePairs(input2)); // Expected: {key1=value1, key2=value2}

        String input3 = "invalidpair noequal";
        System.out.println(parseKeyValuePairs(input3)); // Expected: {}

        // Test cases for the second method (with type conversion)
        System.out.println("\nTesting parseKeyValuePairsWithTypes:");
        String input4 = "foo=bar age=25";
        Map<String, Class<?>> types = new HashMap<>();
        types.put("foo", String.class);
        types.put("age", Integer.class);
        Map<String, Object> result = parseKeyValuePairsWithTypes(input4, types);
        System.out.println(result); // Expected: {foo=bar, age=25}
        String input5 = "height=5.9 isStudent=true invalidKey=something";
        types.put("height", Double.class);
        types.put("isStudent", Boolean.class);
        types.put("invalidKey", Integer.class);  // Invalid key type
        result = parseKeyValuePairsWithTypes(input5, types);
        System.out.println(result); // Expected: {height=5.9, isStudent=true}, ignore invalidKey
    }
}
