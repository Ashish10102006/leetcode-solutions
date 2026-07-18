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