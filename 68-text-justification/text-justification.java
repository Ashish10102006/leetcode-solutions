// Greedy + Simulation

// Greedy → pack as many words as possible per line (don't backtrack)
// Simulation → manually build each line exactly as the problem describes
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result =new ArrayList<>();
        int n = words.length;
        int i=0;
        while(i<n){
            int lettersCount = words[i].length();
            int j = i + 1;
            int spaceSlots = 0;
            while(j<n && lettersCount+spaceSlots+words[j].length()+1 <=maxWidth){
                lettersCount +=words[j].length();
                spaceSlots++;
                j++;
            }
            int remainingSlots = maxWidth - lettersCount;
            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;
            int extraSpace    = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

            if (j == n) { // last line → left justified
                eachWordSpace = 1;
                extraSpace = 0;
            }
            result.add(getFinalWord(i, j, eachWordSpace, extraSpace, words,maxWidth));
            i = j;
        }
        return result;
    }
     private String getFinalWord(int i, int j, int eachWordSpace, int extraSpace, String[] words,int maxWidth) {
        StringBuilder s = new StringBuilder();

        for (int k = i; k < j; k++) {
            s.append(words[k]);

            if (k == j - 1) continue;//if this is the last word in the line, skip adding spaces after it.

            for (int space = 1; space <= eachWordSpace; space++)
                s.append(" ");

            if (extraSpace > 0) {
                s.append(" ");
                extraSpace--;
            }
        }

        while (s.length() < maxWidth)
            s.append(" ");

        return s.toString();
    }
}