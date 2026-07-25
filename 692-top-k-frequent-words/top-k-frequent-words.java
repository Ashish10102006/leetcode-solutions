class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map= new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        // Store all unique words
        List<String> list = new ArrayList<>(map.keySet());

        // Sort by frequency (descending), then lexicographically (ascending)
        Collections.sort(list, (a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            return a.compareTo(b);
        });

        // Return first k words
        return list.subList(0, k);
    }
}
/*
1. Common Patterns
Requirement	Comparator
Integer Ascending	a - b
Integer Descending	b - a
String A → Z	a.compareTo(b)
String Z → A	b.compareTo(a)
Frequency High → Low	freq(b) - freq(a)
Frequency Low → High	freq(a) - freq(b)

2. Golden Rule ⭐

Before writing a comparator, ask:

Who should come first?

Smaller first → a - b
Larger first → b - a
Alphabetically first → a.compareTo(b)
Reverse alphabetical → b.compareTo(a)

3. One-Line Memory Trick
Negative → a first
Positive → b first
Zero → Equal
*/