import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        // First row
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        // Build remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> newRow = new ArrayList<>();

            newRow.add(1); // first element is always 1

            // middle elements
            for (int j = 1; j < i; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            newRow.add(1); // last element is always 1

            result.add(newRow); // add this row to result
        }

        return result;
    }
}