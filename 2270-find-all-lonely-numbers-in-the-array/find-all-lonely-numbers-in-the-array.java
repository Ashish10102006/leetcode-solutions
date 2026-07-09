class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int no:nums){
            map.put(no,map.getOrDefault(no,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int no:nums){
            int prev=no-1;
            int next=no+1;
            if(map.get(no)==1 && !map.containsKey(prev) && !map.containsKey(next)){
                ans.add(no);
            }
        }
        return ans;
    }
}