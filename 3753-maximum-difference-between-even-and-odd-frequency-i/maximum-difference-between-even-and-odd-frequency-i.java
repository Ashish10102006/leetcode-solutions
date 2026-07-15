class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int max_odd=0;
        int min_even=0;
        for(int no:map.values()){
            if(no%2 !=0){
                if(no>max_odd) max_odd=no;
            }
            else{
                if(min_even==0){
                    min_even=no;
                }
                else{
                    if(no<min_even) min_even=no;
                }
            }
        }
        return max_odd-min_even;
    }
}