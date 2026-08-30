class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        
        int low=1;
        int high=0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans=high;
        while(low <= high){
            int mid = low + (high - low) / 2;

            long hours = 0;
            // Calculate hours needed at speed mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if(hours<=h){
                ans=mid;
                high=mid-1;
            }
            else {
                // mid is too slow, increase speed
                low = mid + 1;
            }

        }
        return ans;
    }
}