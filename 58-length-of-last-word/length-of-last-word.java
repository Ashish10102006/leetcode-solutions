class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int lastindexof= s.lastIndexOf(' ');
        return s.length()-(lastindexof+1);
    }
}