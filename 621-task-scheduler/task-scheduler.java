class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> pq =new PriorityQueue(Collections.reverseOrder());
        for(int value:map.values()) pq.offer(value);

        int totalTime = 0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while(cycle>0){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    totalTime++;
                    
                    if(freq>0)temp.add(freq);
                }
                else{
                    if(temp.isEmpty()) break;

                    totalTime++;   // idle
                }
                cycle--;
            }
            for (int f : temp) pq.offer(f);
        }
        return totalTime;
    }
}