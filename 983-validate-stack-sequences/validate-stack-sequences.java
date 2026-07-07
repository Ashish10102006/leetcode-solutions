// Push every element. After each push, keep popping as long as the stack's top matches the next required element in popped.
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int j=0;// Points to the next element we need to pop

        for (int num : pushed) {
            // Push the current element
            stack.push(num);

            // Keep popping while the top matches the required popped element
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}