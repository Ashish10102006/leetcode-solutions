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