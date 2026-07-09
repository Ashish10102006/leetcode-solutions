import java.util.*;
/*
class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        List<Integer> indices = new ArrayList<>();

        char[] arr = s.toCharArray();

        // Store vowels and their indices
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                pq.offer(arr[i]);
                indices.add(i);
            }
        }

        // Replace vowels with sorted vowels
        for (int index : indices) {
            arr[index] = pq.poll();
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
*/

// 2nd Approch
import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Extract vowels
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        // Sort vowels by ASCII
        Collections.sort(vowels);

        char[] arr = s.toCharArray();
        int j = 0;

        // Put sorted vowels back
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = vowels.get(j++);
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}