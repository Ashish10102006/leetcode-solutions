class Solution {
  public String largestGoodInteger(String num) {
    String[] goodIntegers = new String[] { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };
    for (String goodInt : goodIntegers) {
      if (num.contains(goodInt)) {
        return goodInt;
      }
    }
    return "";
  }
}