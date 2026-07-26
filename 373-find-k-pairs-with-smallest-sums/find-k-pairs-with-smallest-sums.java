/*
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) ->(a[0] + a[1]) - (b[0] + b[1]));
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                pq.add(new int[]{nums1[i],nums2[j]});
            }
        }

        List<List<Integer>> ans =new ArrayList<>();
        for(int i=1;i<=k && !pq.isEmpty();i++){
           int[] pair = pq.poll();
           ans.add(Arrays.asList(pair[0], pair[1]));
        }
        return ans;
    }
}
*/ // Memory Limit Exceeded
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return ans;

        // Min Heap stores {index in nums1, index in nums2}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // Insert the first pair of each row
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            // Insert the next pair from the same row
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }

            k--;
        }

        return ans;
    }
}
/*
Example
nums1 = [1, 7, 11]
nums2 = [2, 4, 6]
Row 1: (1,2)  (1,4)  (1,6)
        3      5      7

Row 2: (7,2)  (7,4)  (7,6)
        9     11     13

Row 3: (11,2) (11,4) (11,6)
        13    15     17

Now I ask you:

What is the first person standing in each queue?

Answer:

(1,2)
(7,2)
(11,2)

These are the only people who can come out first.

So we put them into the heap.

Now suppose the heap removes:

(1,2)

What is now standing at the front of Row 1?

(1,4)

So we put only (1,4) into the heap.

Now the heap contains

(1,4)
(7,2)
(11,2)

Now suppose the heap removes

(1,4)

Who is now at the front of Row 1?

(1,6)

So we insert

(1,6)
Why don't we insert all three?

Suppose initially you inserted

(1,2)
(1,4)
(1,6)

Can (1,6) ever be chosen before (1,4)?

No.

Can (1,4) ever be chosen before (1,2)?

No.

Because

3 < 5 < 7

So (1,4) and (1,6) are just waiting unnecessarily.

That's why we insert them only when they reach the front.

One sentence to remember

The heap always stores only the current smallest unused pair from each row.        
*/