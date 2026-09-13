class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        List<String> curr = new ArrayList<>();

        helper(s, 0, curr, result);

        return result;
    }
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        
        // Use .equals() for content comparison
        return s.equals(new StringBuilder(s).reverse().toString());
    } 

    public void helper(String s, int start, List<String> curr,List<List<String>> result) {
        if(start==s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int end=start;end<s.length();end++){
            String part=s.substring(start,end+1);

            if (isPalindrome(part)){

                // CHOOSE
                curr.add(part);

                // EXPLORE
                helper(s, end + 1, curr, result);

                // BACKTRACK
                curr.remove(curr.size() - 1); 
            }
        }
    }


}