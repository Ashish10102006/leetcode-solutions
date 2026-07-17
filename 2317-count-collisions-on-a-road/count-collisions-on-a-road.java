class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();

        int left = 0;
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        int right = n - 1;
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;

        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
// left = first index that is not 'L'
// right = last index that is not 'R'
// answer = 0
// for i = left to right
//     if directions[i] != 'S'
//         answer++