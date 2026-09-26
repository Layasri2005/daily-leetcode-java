import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // 1. Store knowledge in HashMap
        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        // 2. Store final answer
        StringBuilder result = new StringBuilder();

        // 3. Traverse the string
        int i = 0;

        while (i < s.length()) {

            // If current character is '('
            if (s.charAt(i) == '(') {

                // Find closing bracket
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                // Extract key between brackets
                String key = s.substring(i + 1, j);

                // Check key in HashMap
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append("?");
                }

                // Move i after ')'
                i = j + 1;

            } else {

                // Normal character
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
