// At every level of the stack, minStack stores the minimum element from the bottom of the stack up to that level.
class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> minStack ;
    public MinStack() {
        stack = new Stack<>();
        minStack= new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        // If minStack is empty or new value is smaller,
        // push the new value as the current minimum.
        if(minStack.isEmpty() || value < minStack.peek() ){
            minStack.push(value);
        }
        else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */