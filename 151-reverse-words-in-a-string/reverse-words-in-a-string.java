class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String words[]=s.split("\\s+");
        StringBuilder sb= new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}
// "\\s+"

// the \s means whitespace.

// Whitespace includes:

// normal space: " "
// tab: \t
// new line: \n
// s.split("\\s+")

// means:

// Split the string wherever there are one or more whitespace characters.

// The + means one or more.