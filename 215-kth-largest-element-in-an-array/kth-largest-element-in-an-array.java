// Keep a min heap of size k, always remove smallest when size exceeds k.
// Keep only the K largest elements in a min heap.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap =new  PriorityQueue<>();

        for(int i=0;i<k;i++){
            minheap.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(nums[i]>minheap.peek()){
                minheap.poll();
                minheap.add(nums[i]);
            }
        }
        return minheap.poll();
    }
}