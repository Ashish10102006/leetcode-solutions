// For every 0, add currentIndex - targetIndex (i - left) because that is the minimum number of adjacent swaps needed to move it to its correct position on the left.
class Solution {
    public long minimumSteps(String s) {
        int left=0;
        int index=0;
        long result=0;
        while(index<s.length()){
            if(s.charAt(index)=='0'){
                result+=index-left;
                left++;
            }
            index++;
        }
        return result;
    }
}