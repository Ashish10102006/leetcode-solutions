import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Use a list to build result dynamically
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // Case 1: No overlap — add interval as-is
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            }
            // Case 2: Overlap — extend the end of last interval
            else {
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    interval[1]
                );
            }
        }

        // Step 3: Convert List<int[]> back to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}
// ```

// ---

// ## Step-by-Step Logic
// ```
// Input: [[1,3],[2,6],[8,10],[15,18]]

// ① Sort by start → [[1,3],[2,6],[8,10],[15,18]]

// ② Iterate:
//    [1,3]  → merged is empty         → ADD    → merged: [[1,3]]
//    [2,6]  → 2 <= 3 (overlap)        → MERGE  → merged: [[1,6]]
//    [8,10] → 8 > 6  (no overlap)     → ADD    → merged: [[1,6],[8,10]]
//    [15,18]→ 15 > 10 (no overlap)    → ADD    → merged: [[1,6],[8,10],[15,18]]

// ③ Output: [[1,6],[8,10],[15,18]]
// ```

// ---

// ## Why `Math.max` for the end?

// Handles the **containment case** where one interval is fully inside another:
// ```
// [[1,10],[2,5]]

// [1,10] → ADD    → merged: [[1,10]]
// [2,5]  → overlap (2 <= 10)
//          max(10, 5) = 10  → merged: [[1,10]]  ✓