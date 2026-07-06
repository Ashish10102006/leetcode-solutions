class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> monotonicStack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!monotonicStack.isEmpty() && temperatures[i] >= temperatures[monotonicStack.peek()] ){
               monotonicStack.pop();
            }
            if (!monotonicStack.isEmpty()) {
                answer[i] = monotonicStack.peek() - i;
            }
            monotonicStack.push(i);
        }
        return answer;
    }
}




/*
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
}
problem =last test case not based
TC=O(N^2)
*/
