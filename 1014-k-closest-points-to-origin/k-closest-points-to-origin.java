class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1] , b[0] * b[0] + b[1] * b[1]));

        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
        }


        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
            }

            return result;
    }
}
/*

Quick rule to remember:

1st-Way:
Ascending order (min-heap):
Integer.compare(a, b)
or
a - b

Descending order (max-heap):
Integer.compare(b, a)
or
b - a

< 0 → a first
> 0 → b first
0 → same priority

2-Way:
(a, b) -> valueOfA - valueOfB
*/