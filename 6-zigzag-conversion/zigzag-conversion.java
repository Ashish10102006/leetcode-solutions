//logic
// “We distribute characters into multiple StringBuilders row-wise in zigzag order, then merge them.”
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int dir = 1;

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            if (row == 0) dir = 1;
            else if (row == numRows - 1) dir = -1;

            row += dir;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}
// 🔥 Meaning of each line
// 1. if (row == 0) dir = 1;
// 👉 If you are at the top row, you must go DOWN.
// So:
// direction = +1
// 2. else if (row == numRows - 1) dir = -1;
// 👉 If you are at the bottom row, you must go UP.
// So:
// direction = -1
// 3. row += dir;
// 👉 Move to next row based on direction:
// dir = +1 → go down
// dir = -1 → go up

// 0r usung while loop

//char arr[]=s.toCharArray()
// int n = arr.length;
// int index = 0;

// //Traverse zig zag
// while(index < n){
// //Go down
// for(int j = 0; j < numRows && index < n; j++){
// sbs[j].append(arr[index++]);
// }
// //Go Up before start
// for(int j = numRows - 2; j > 0 && index < n; j--){
// sbs[j].append(arr[index++]);
// }
