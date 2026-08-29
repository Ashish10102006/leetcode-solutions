class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int duplicate=-1;
        for(int key:map.keySet()){
            if(map.get(key)==2){
                duplicate=key;
                break;
            }
        }
        
        int n=nums.length;
        int totalSum=(n*(n+1))/2;

        int currentSum=0;
        for (int num : nums) {
            currentSum += num;
        }

        int missing = totalSum - (currentSum - duplicate);


        return new int[]{duplicate,missing};
    }
}