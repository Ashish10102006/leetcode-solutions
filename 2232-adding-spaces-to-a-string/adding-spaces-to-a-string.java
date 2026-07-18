/*
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder(s);

        int offset = 0;
        for (int i : spaces) {
            str.insert(i + offset, ' ');
            offset++;
        }

        return str.toString();
    }
}
//offset means how many extra characters (spaces) have already been inserted.
*/
class Solution {
    public String addSpaces(String s, int[] spaces) {
      StringBuilder result=new StringBuilder();
      int prev=0;
      for(int space:spaces) {
        result.append(s.substring(prev,space));
        result.append(' ');
        prev=space;
      
      } 
      result.append(s.substring(prev));
      return result.toString();
    }
}    