import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();

        // Store indices of unmatched parentheses
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else if (s.charAt(i) == ')') {

                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();              // Matched pair
                } else {
                    stack.push(i);            // Unmatched ')'
                }
            }
        }

        // Store all invalid indices
        HashSet<Integer> remove = new HashSet<>();

        while (!stack.isEmpty()) {
            remove.add(stack.pop());
        }

        // Build the answer
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}

// We use a HashSet because it provides O(1) average-time lookup for invalid indices, whereas stack.contains() takes O(n), which would make the overall algorithm O(n²).