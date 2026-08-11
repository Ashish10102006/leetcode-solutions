class Solution {
    public int calculate(String s) {
        int result=0;
        int number=0;
        int sign=1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){

             char c = s.charAt(i);

            // Build number
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            // When we see +
            else if(c=='+'){
                result = result + (sign*number);
                number = 0;
                sign = 1;
            }
            // When we see -
            else if(c=='-'){
                result = result + (sign*number);
                number = 0;
                sign = -1;
            }
            // When we see (
            else if(c=='('){
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }
            // When we see )
            else if(c==')'){
                result += sign * number;
                number = 0;

                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }
        }

        // Add final number
        result += sign * number;

        return result;
    }
}
/*
We need to remember:

result → current calculation
sign → whether the next number is + or -
number → number currently being built
When we see ( → save the current calculation
When we see ) → finish the calculation inside the brackets and combine it with the outside

A stack is perfect for remembering the outside calculation.


1. Why add the final answer?
The last number has no + or - after it, so it never gets added inside the loop.
Example:
1 + 2
When + comes → 1 is added.
But 2 is the last number → after the loop we add it:
result += sign * number;

2. Why don't we set number = 0 at (?
Because when ( comes, the previous + or - has already reset number to 0.
else if (c == '+') {
    result += sign * number;
    number = 0;
    sign = 1;
}
So at (, number is already 0.
Instead, we reset:
result = 0;
because we want to calculate the expression inside the brackets separately.
*/