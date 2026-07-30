class Solution {
    public String reorganizeString(String s) {
        int n=s.length();

        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        // Check if reorganization is possible
        for (int freq : map.values()) {
            if (freq > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb=new StringBuilder();

        while(pq.size()>=2){
            Map.Entry<Character, Integer> first = pq.poll();
            Map.Entry<Character, Integer> second = pq.poll();

            sb.append(first.getKey());
            sb.append(second.getKey());

            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);

            if (first.getValue() > 0) {
                pq.offer(first);
            }

            if (second.getValue() > 0) {
                pq.offer(second);
            }
  
        }
        if (!pq.isEmpty()) {
            sb.append(pq.poll().getKey());
        }

        return sb.toString();
    }
}
/*
Let the maximum frequency be f.
Other characters = n - f
To separate all occurrences:
n - f ≥ f - 1(gaps)
⇒ n + 1 ≥ 2f
⇒ f ≤ (n + 1) / 2
Therefore, if maxFrequency > (n + 1) / 2, rearrangement is impossible.

Term	                     Meaning
Map.Entry<K, V>       	One key-value pair
map.entrySet()	        A Set containing all key-value pairs in the map
*/