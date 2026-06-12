class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) {
            return "";  // If no strings, return empty
        }
        
        String prefix = strs[0];  // Start prefix as the first string
        
        // Loop through all other strings
        for (int i = 1; i < strs.length; i++) {
            // While current string does NOT start with prefix
            while (!strs[i].startsWith(prefix)) {
                // Remove the last character from prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix is empty, return empty string (no common prefix)
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;  // Return the longest common prefix found
    
    }
}