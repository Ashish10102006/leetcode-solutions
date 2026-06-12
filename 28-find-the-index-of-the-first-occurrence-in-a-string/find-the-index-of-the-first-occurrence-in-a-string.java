class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle))
        return -1;
        int r = haystack.indexOf(needle);
        return r;
    }
}