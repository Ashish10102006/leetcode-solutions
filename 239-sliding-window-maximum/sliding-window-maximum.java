/*
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        int result[] = new int[ n- k + 1];
        int l=0;

        for(int i=0;i<result.length;i++){
            int currMax = Integer.MIN_VALUE;
             for(int j=i;j<i+k;j++){
                currMax = Math.max(currMax, arr[j]);
            }
            result[l++]=currMax;
        }
        return result;
    }
}
// How many windows are possible?
// Formula : Number of windows = n - k + 1
*/
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int ans[]=new int[n-k+1];
        int ansIndex=0;
        //Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0;i<n;i++){

            //The old index is removed because it is no longer inside the current window.
            if(!dq.isEmpty() && dq.peekFirst()<=(i-k)) 
            dq.pollFirst();

            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }

            dq.offerLast(i);     

            if(i>=(k-1)) ans[ansIndex++]=arr[dq.peekFirst()];
        }
        return ans;
    }
}