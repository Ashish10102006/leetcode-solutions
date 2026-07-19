class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s=s.replaceFirst(part,"");
        }
        return s;
    }
}
// Method	                What it does
// replace(old, new)	    Replaces all occurrences of old.
// replaceFirst(old, new)	Replaces only the first occurrence of old.