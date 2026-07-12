/*
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int no:nums){
            set.add(no);
        }
        int missing_no=-1;
        for(int i=0;i<nums.length+1;i++){
            if(!set.contains(i)){
                missing_no=i;
                break;
            }
        }
        return missing_no;
    }
}
*/
//optimal method1=expectedSum - actualSum
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

/*
optimal method2 =xor
int xor = nums.length;

for (int i = 0; i < nums.length; i++) {
    xor ^= i;
    xor ^= nums[i];
}
a ^ a = 0
a ^ 0 = a
*/