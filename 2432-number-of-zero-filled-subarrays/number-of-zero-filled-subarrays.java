
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total=0;
        long countzeros=0;
        for(int n:nums){
            if(n==0){
                countzeros++;
                total+=countzeros;
            }
            else{
                countzeros=0;
            }
        }
        return total;

    }
}

/*
//2nd -approch
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long count = 0;

        for (int n : nums) {
            if (n == 0) {
                count++;
            } else {
                total += count * (count + 1) / 2;
                count = 0;
            }
        }

        // For the last zero block (if the array ends with zeros)
        total += count * (count + 1) / 2;

        return total;
    }
}*/