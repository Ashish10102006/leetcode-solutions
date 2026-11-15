/*
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
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Your code goes here
        int freq[]=new int[26];
        for(char task:tasks) freq[task-'A']++;

        Arrays.sort(freq);
        int maxFreq=freq[25];
        int maxCount=0;
        for(int i=25;i>=0;i--) 
        {
            if(maxFreq==freq[i]) maxCount++;
            else break;
        }
        int partCount=maxFreq-1;
        int partLength=n+1;
        int emptySlots = partCount * partLength + maxCount;

        return Math.max(emptySlots,tasks.length);
    }
}
/*

### 1. Main Formula

**emptySlots = (maxFreq - 1) × (n + 1) + maxCount**

### 2. Meaning of Each Variable

- **maxFreq:** Highest frequency of any task.
- **n:** Cooldown interval.
- **maxCount:** Number of tasks having the highest frequency.
- **partCount:** Number of sections = maxFreq - 1.
- **partLength:** Length of each section = n + 1.

**Why do we add + maxCount?**

We add maxCount because we must include the last occurrence of every task that has the maximum frequency.

### 3. Why Math.max()?

```java
return Math.max(tasks.length, emptySlots);
```

- **tasks.length:** Total number of tasks that must be executed.
- **emptySlots:** Minimum intervals required because of task frequency and cooldown.

**Take the bigger value!**

Remember:
- If cooldown requires more intervals → use emptySlots.
- If there are more tasks → use tasks.length.

That's why we use Math.max().
*/