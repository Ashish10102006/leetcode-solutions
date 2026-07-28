class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int no:nums){
            map.put(no,map.getOrDefault(no,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        for(int key:map.keySet()){
            pq.add(key);
        }

        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }

        return ans;
    }
}