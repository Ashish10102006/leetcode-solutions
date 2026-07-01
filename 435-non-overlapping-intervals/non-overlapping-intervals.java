class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        List<int[]> list=new ArrayList<>();
        for(int[] interval:intervals){
            if(list.isEmpty() || list.get(list.size()-1)[1] <= interval[0]){
                list.add(interval);
            }
        }
         return intervals.length - list.size();
    }
}