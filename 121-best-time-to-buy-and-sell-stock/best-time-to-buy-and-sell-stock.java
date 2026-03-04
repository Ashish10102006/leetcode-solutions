class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyprice= prices[0];
        int max_profit=0;
        for(int i=1;i<n;i++){
            int c_profit=prices[i]-buyprice;
            if(c_profit>max_profit) max_profit=c_profit;
            if(prices[i]<buyprice) buyprice=prices[i];

        } return max_profit;

      }
     
}