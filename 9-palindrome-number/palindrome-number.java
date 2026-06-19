class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }  
        int rev=0;
        int original =x;
        while(x!=0){
            int r = x%10;
            rev=(rev*10) + r;
           x= x/10;
        }
        return rev==original ? true:false;
    }
}