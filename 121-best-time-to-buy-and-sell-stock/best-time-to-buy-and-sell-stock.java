class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;
        int currProfit = 0;
        int maxProfit = 0;
        int minPrice = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            } else {
                currProfit = arr[i] - minPrice;
                maxProfit = Math.max(currProfit, maxProfit);
            }
        }

        return maxProfit;

      }
     
}