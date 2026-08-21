/*
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int rowIndexNumber=0;
        for(int i=0;i<=rowIndex;i++){
            rowIndexNumber=(int)Math.pow(11,i);
        }

        List<Integer> result= new ArrayList<>();
        String s= String.valueOf(rowIndexNumber);

        for(char c:s.toCharArray()){
            result.add(c-'0');
        }

        return result;
    }
}
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        long value = 1;

        for (int i = 0; i <= rowIndex; i++) {
            result.add((int)value);

            value = value * (rowIndex - i) / (i + 1);
        }

        return result;
    }
}