//Better sol

// Sort the array, ignore duplicates, increase the count if the current number is previous + 1, otherwise start a new sequence, and keep track of the maximum count.

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Arrays.sort(nums);
//         int last_smaller = Integer.MIN_VALUE;
//         int longest=0;
//         int counter=1;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]-1==last_smaller){
//                 counter++;
//                 last_smaller=nums[i];
//             }
//             if(nums[i]!=last_smaller){
//                 counter=1;
//                 last_smaller=nums[i];
//             }
//             longest=Math.max(counter,longest);
//         }
//         return longest;
//     }
// }

//Optimal Soln
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest=0;
        for(int no:nums)
        set.add(no);

        for(int num:set){
            if(!set.contains(num-1)){
                int current = num;
                int count = 1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}    

// Put all numbers in a HashSet, and whenever a number has no previous number (num - 1), treat it as the start of a sequence and count forward to find the longest streak.