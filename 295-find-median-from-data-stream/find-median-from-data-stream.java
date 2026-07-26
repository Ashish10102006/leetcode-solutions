class MedianFinder {
    PriorityQueue<Integer> left;   // Max Heap
    PriorityQueue<Integer> right;  // Min Heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num); 
        right.offer(left.poll()); 

        if (right.size() > left.size()) {
             left.offer(right.poll()); 
            }
            /*
            Every element in left <= Every element in right
            
            1. Put the number into LEFT.
            2. Move the largest from LEFT to RIGHT.
            3. If RIGHT becomes bigger,move its smallest back to LEFT.
            */

    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 /*
 class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int n=list.size();
        if(n%2!=0){
            return list.get(n/2);
        }
        else{
            return (list.get(n/2 -1) + list.get(n/2))/2.0;
        }
    }
}
*/  // TLE