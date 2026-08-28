class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int no:nums){
            map.put(no,map.getOrDefault(no,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>(n/3))result.add(key);
        }

        return result;
    }
}
/*
More than n/2 → maximum 1 element

More than n/3 → maximum 2 elements

More than n/k → maximum k-1 elements
*/