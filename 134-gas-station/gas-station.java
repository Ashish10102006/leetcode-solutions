// That’s the whole pattern:
// total sum check
// greedy reset when negative
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalGas=0,totalCost=0;
        //  find toal gas and total cost
        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas < totalCost) return -1;
        int start=0;
        int currentGas=0;
        // else totalGas >= totalCost
            for(int i=0;i<n;i++){
                currentGas=currentGas + (gas[i]-cost[i]);
                if(currentGas<0){
                    start=i+1;//We jump to i + 1 because everything from previous start to i is proven impossible as a starting point.
                    currentGas=0;
                }
            }
            return start;
    }
}

// 🧠 What “greedy” means (simple)
// A greedy algorithm:
// “Take the best immediate choice, and never revisit past choices.”
// No backtracking, no re-checking.
// ⚡ Where greedy happens in Gas Station
// While scanning:
// tank += gas[i] - cost[i]
// If tank becomes negative:
// You do:
// start = i + 1
// tank = 0

// 🔥 Why is this GREEDY?
// Because you are making this decision:
// “All previous start positions are useless → discard them forever”
// You are NOT checking them again.
// That is the greedy part.