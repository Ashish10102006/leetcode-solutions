class Solution {
    public int firstUniqChar(String s) {
        int index=-1;
        for(char c:s.toCharArray()){
            if(s.indexOf(c)==s.lastIndexOf(c)){
                index=s.indexOf(c);
                break;
            }
        }
        return index;
    }
}