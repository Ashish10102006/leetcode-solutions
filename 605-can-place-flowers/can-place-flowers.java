// For every position i:

// Is flowerbed[i] empty (0)?
// Is the left neighbor empty (or does not exist)?
// Is the right neighbor empty (or does not exist)?
//Only if all three conditions are satisfied can you plant a flower there.

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;
                count++;

                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;//"Have I planted at least n flowers?"
    }
}