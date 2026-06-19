class Solution {
    public int[] plusOne(int[] digits) {
        int n= digits.length-1;
        for(int i=n;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i]=0;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        // int[] ans = new int[4]; // [0,0,0,0]
        // ans[0] = 1;             // [1,0,0,0]
        return digits;
    }
}