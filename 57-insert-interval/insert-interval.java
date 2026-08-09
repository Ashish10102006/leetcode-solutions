class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;

        // LEFT
        while (i < intervals.length &&
               intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        // MIDDLE
        while (i < intervals.length &&
               intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }
        list.add(newInterval);

        // RIGHT
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
/*
Yes, almost. One small correction:

LEFT: intervals that are completely before newInterval → don't change
MIDDLE: overlapping intervals → merge and find the smallest start + largest end
RIGHT: intervals completely after the merged interval → don't change

So:

LEFT    → unchanged
MIDDLE  → merge → smallest start, largest end
RIGHT   → unchanged
*/