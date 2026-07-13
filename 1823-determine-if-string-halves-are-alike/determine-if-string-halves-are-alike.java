class Solution {
    public boolean halvesAreAlike(String s) {
        int length=s.length();
        int half=length/2;
        int vowel_left=0;
        int vowel_right=0;
        for(int i=0;i<half;i++){
            if(isVowel(s.charAt(i))) vowel_left++;
            if(isVowel(s.charAt(i+half))) vowel_right++;
        }
        return vowel_left==vowel_right;
    }
    public boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}