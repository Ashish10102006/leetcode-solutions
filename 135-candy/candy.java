// Best Approach for Candy Problem
// 👉 Use Two-pass Greedy

// 🧠 Core Idea
// You cannot decide candies in one direction because:
// Left neighbor affects right
// Right neighbor affects left
// So you scan twice.

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int candies[]=new int[n];
        Arrays.fill(candies,1);//Each child must have at least one candy.

        // left to right
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1; //“We enforce a rule: this child must have at least one more than neighbor”
            }
        }

        // right to left
        for(int i=n-2;i>=0;i--){
            if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);//“We enforce a rule: this child must have at least one more than neighbor”
            }
        }
        int sum = 0;
        for (int c : candies) sum += c;
        return sum;
    }
}

// Why max()?
// Because:
// Left pass might already give a good value
// Right pass might require bigger value
// You always keep the better (larger) requirement