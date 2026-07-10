class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1=new StringBuilder();
        StringBuilder str2=new StringBuilder();
        for(String s1:word1) str1.append(s1);
        for(String s2:word2) str2.append(s2);

        return str1.toString().equals(str2.toString());
    }
}