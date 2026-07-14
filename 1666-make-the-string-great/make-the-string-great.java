class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        StringBuilder str=new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}

// There is a property of ASCII characters:

// 'a' = 97
// 'A' = 65

// Difference:

// 97 - 65 = 32

// This is true for every English letter:
// 'a' - 'A' = 32
// 'b' - 'B' = 32
// 'c' - 'C' = 32
// ...
// 'z' - 'Z' = 32