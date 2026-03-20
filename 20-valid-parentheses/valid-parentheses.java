class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If closing bracket, stack must not be empty and top must match
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // At the end, stack must be empty
        return stack.isEmpty();
    }
}