class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            // Right-moving asteroid
            if (asteroid > 0) {
                stack.push(asteroid);
            } 
            // Left-moving asteroid
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == -asteroid) {
                    stack.pop(); // Both explode
                } 
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // Current asteroid survives
                }
                // Else: stack.peek() > -asteroid
                // Current asteroid explodes, so do nothing
            }
        }

        int[] ans = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}
// Remember these 3 checks in order
// Smaller positive? → Pop it.
// Equal size? → Pop it (both explode).
// No positive left? (stack empty or top is negative) → Push the current asteroid.

// If none of these are true, the current asteroid is destroyed and you simply move to the next asteroid.